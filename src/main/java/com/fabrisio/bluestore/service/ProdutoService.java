package com.fabrisio.bluestore.service;

import com.fabrisio.bluestore.dto.ProdutoDto;
import com.fabrisio.bluestore.entity.ProdutoEntity;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    ProdutoEntity cadastrar(ProdutoDto model);
    ProdutoEntity alterar(UUID id, ProdutoDto model);
    void apagar(UUID id);
    List<ProdutoEntity> listar();
    ProdutoEntity consultar(UUID id);

}
