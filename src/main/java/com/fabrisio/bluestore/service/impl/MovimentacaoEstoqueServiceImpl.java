package com.fabrisio.bluestore.service.impl;

import com.fabrisio.bluestore.dto.MovimentacaoEstoqueDto;
import com.fabrisio.bluestore.entity.ItemEstoqueEntity;
import com.fabrisio.bluestore.entity.MovimentacaoEstoqueEntity;
import com.fabrisio.bluestore.enuns.EnumTipoMovimentacao;
import com.fabrisio.bluestore.repository.MovimentacaoEstoqueRepository;
import com.fabrisio.bluestore.service.ItemEstoqueService;
import com.fabrisio.bluestore.service.MovimentacaoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MovimentacaoEstoqueServiceImpl implements MovimentacaoEstoqueService {

    @Autowired
    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    @Override
    public MovimentacaoEstoqueEntity cadastrar(MovimentacaoEstoqueDto model) {
        return movimentacaoEstoqueRepository.save(new MovimentacaoEstoqueEntity(model.getId(), model.getIdItemEstoque(),
                model.getQtd(), model.getMovimentacao(), model.getData(), LocalDateTime.now(), LocalDateTime.now()));
    }

    @Override
    public MovimentacaoEstoqueEntity alterar(UUID id, MovimentacaoEstoqueDto model) {
        MovimentacaoEstoqueEntity entity = consultar(id);
        entity.atualizar(model);
        return movimentacaoEstoqueRepository.save(entity);
    }

    @Override
    public void apagar(UUID id) {
        movimentacaoEstoqueRepository.deleteById(id);
    }

    @Override
    public List<MovimentacaoEstoqueEntity> listar() {
        return movimentacaoEstoqueRepository.findAll();
    }

    @Override
    public MovimentacaoEstoqueEntity consultar(UUID id) {
        return movimentacaoEstoqueRepository.findById(id).orElseThrow();
    }
}
