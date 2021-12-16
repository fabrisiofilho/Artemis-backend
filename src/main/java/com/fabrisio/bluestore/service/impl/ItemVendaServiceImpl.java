package com.fabrisio.bluestore.service.impl;

import com.fabrisio.bluestore.dto.ItemVendaDto;
import com.fabrisio.bluestore.dto.MovimentacaoEstoqueDto;
import com.fabrisio.bluestore.dto.VendaDto;
import com.fabrisio.bluestore.entity.ItemEstoqueEntity;
import com.fabrisio.bluestore.entity.ItemVendaEntity;
import com.fabrisio.bluestore.entity.VendaEntity;
import com.fabrisio.bluestore.enuns.EnumTipoMovimentacao;
import com.fabrisio.bluestore.exceptions.SendEmailException;
import com.fabrisio.bluestore.repository.ItemVendaRepository;
import com.fabrisio.bluestore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ItemVendaServiceImpl implements ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ItemEstoqueService itemEstoqueService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    @Override
    public ItemVendaEntity cadastrar(ItemVendaDto model) {
        validarVenda(model);
        return itemVendaRepository.save(new ItemVendaEntity(model.getId(), model.getIdProduto(),
                model.getQtd(), calcularValorTotal(produtoService.consultar(model.getIdProduto()).getValor(),model.getQtd()), model.getVenda_id(), model.getDesconto(), LocalDateTime.now()
                , LocalDateTime.now()));
    }

    public BigDecimal calcularValorTotal(BigDecimal valorProduto, Integer qtd){
        return valorProduto.multiply(BigDecimal.valueOf(qtd));
    }

    @Override
    public ItemVendaEntity alterar(UUID id, ItemVendaDto model) {
        ItemVendaEntity entity = consultar(id);
        entity.atualizar(model);
        return itemVendaRepository.save(entity);
    }

    @Override
    public void apagar(UUID id) {
        ItemVendaEntity entity = consultar(id);
        criarMovimentacaoEntrada(new ItemVendaDto(entity));
        itemVendaRepository.deleteById(id);
    }

    @Override
    public List<ItemVendaEntity> listar() {
        return itemVendaRepository.findAll();
    }

    @Override
    public ItemVendaEntity consultar(UUID id) {
        return itemVendaRepository.findById(id).orElseThrow();
    }


    public void validarVenda(ItemVendaDto model){
        VendaEntity entityVenda = vendaService.consultar(model.getVenda_id());
        if (entityVenda.isActivated()==false){
            throw new SendEmailException("Venda não está mais ativa");
        }
        entityVenda.atualizarValorTotalAdicionar(calcularValorTotal(produtoService.consultar(model.getIdProduto()).getValor(),model.getQtd()));
        vendaService.cadastrar(new VendaDto(entityVenda));
        criarMovimentacaoSaida(model);
    }

    public void criarMovimentacaoSaida(ItemVendaDto model){
        ItemEstoqueEntity entityEstoque = itemEstoqueService.consultarPorIdProduto(model.getIdProduto());
        itemEstoqueService.removerItem(entityEstoque.getId(), model.getQtd());
        cadastrarMovimentação(new MovimentacaoEstoqueDto(null, entityEstoque.getId()
                , model.getQtd(), EnumTipoMovimentacao.RETIRADA, LocalDateTime.now()));
    }

    public void criarMovimentacaoEntrada(ItemVendaDto model){
        ItemEstoqueEntity entityEstoque = itemEstoqueService.consultarPorIdProduto(model.getIdProduto());
        itemEstoqueService.adicionarItem(entityEstoque.getId(), model.getQtd());
        cadastrarMovimentação(new MovimentacaoEstoqueDto(null, entityEstoque.getId()
                , model.getQtd(), EnumTipoMovimentacao.ENTRADA, LocalDateTime.now()));
    }

    public void cadastrarMovimentação(MovimentacaoEstoqueDto dto){
        movimentacaoEstoqueService.cadastrar(dto);
    }
}
