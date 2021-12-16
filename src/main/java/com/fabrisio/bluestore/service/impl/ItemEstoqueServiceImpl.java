package com.fabrisio.bluestore.service.impl;

import com.fabrisio.bluestore.dto.ItemEstoqueDto;
import com.fabrisio.bluestore.dto.MovimentacaoEstoqueDto;
import com.fabrisio.bluestore.entity.ItemEstoqueEntity;
import com.fabrisio.bluestore.enuns.EnumTipoMovimentacao;
import com.fabrisio.bluestore.repository.ItemEstoqueRepository;
import com.fabrisio.bluestore.repository.MovimentacaoEstoqueRepository;
import com.fabrisio.bluestore.service.ItemEstoqueService;
import com.fabrisio.bluestore.service.MovimentacaoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ItemEstoqueServiceImpl implements ItemEstoqueService {

    @Autowired
    private ItemEstoqueRepository itemEstoqueRepository;

    @Autowired
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    @Override
    public ItemEstoqueEntity cadastrar(ItemEstoqueDto model) {
        ItemEstoqueEntity estoqueEntity = itemEstoqueRepository.save(new ItemEstoqueEntity(model.getId(), model.getIdProduto(),
                model.getQtdEstoque(), LocalDateTime.now(), LocalDateTime.now()));
        cadastrarMovimentação(new MovimentacaoEstoqueDto(null, estoqueEntity.getId() , model.getQtdEstoque(),EnumTipoMovimentacao.ENTRADA, LocalDateTime.now()));
        return estoqueEntity;
    }

    @Override
    public ItemEstoqueEntity alterar(UUID id, ItemEstoqueDto model) {
        ItemEstoqueEntity entity = consultar(id);
        entity.atualizar(model);
        return itemEstoqueRepository.save(entity);
    }

    @Override
    public void apagar(UUID id) {
        itemEstoqueRepository.deleteById(id);
    }

    @Override
    public List<ItemEstoqueEntity> listar() {
        return itemEstoqueRepository.findAll();
    }

    @Override
    public ItemEstoqueEntity consultar(UUID id) {
        return itemEstoqueRepository.findById(id).orElseThrow();
    }

    @Override
    public ItemEstoqueEntity consultarPorIdProduto(UUID id) {
        return itemEstoqueRepository.findByIdProduto(id);
    }

    @Override
    public ItemEstoqueEntity adicionarItem(UUID id, Integer qtd) {
        ItemEstoqueEntity entity = consultar(id);
        entity.adicionarItensNoEstoque(qtd);
        cadastrarMovimentação(new MovimentacaoEstoqueDto(null, entity.getId(), qtd, EnumTipoMovimentacao.ENTRADA, LocalDateTime.now()));
        return entity;
    }

    @Override
    public ItemEstoqueEntity removerItem(UUID id, Integer qtd) {
        ItemEstoqueEntity entity = consultar(id);
        entity.removerItensNoEstoque(qtd);
        cadastrarMovimentação(new MovimentacaoEstoqueDto(null, entity.getId(), qtd, EnumTipoMovimentacao.RETIRADA, LocalDateTime.now()));
        return entity;
    }


    public void cadastrarMovimentação(MovimentacaoEstoqueDto dto){
        movimentacaoEstoqueService.cadastrar(dto);
    }

}
