package com.fabrisio.bluestore.service;

import com.fabrisio.bluestore.dto.MovimentacaoEstoqueDto;
import com.fabrisio.bluestore.entity.MovimentacaoEstoqueEntity;

import java.util.List;
import java.util.UUID;

public interface MovimentacaoEstoqueService {

    MovimentacaoEstoqueEntity cadastrar(MovimentacaoEstoqueDto model);
    MovimentacaoEstoqueEntity alterar(UUID id, MovimentacaoEstoqueDto model);
    void apagar(UUID id);
    List<MovimentacaoEstoqueEntity> listar();
    MovimentacaoEstoqueEntity consultar(UUID id);

}
