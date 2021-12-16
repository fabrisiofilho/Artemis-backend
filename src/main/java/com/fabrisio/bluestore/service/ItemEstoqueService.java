package com.fabrisio.bluestore.service;

import com.fabrisio.bluestore.dto.ItemEstoqueDto;
import com.fabrisio.bluestore.entity.FuncionarioEntity;
import com.fabrisio.bluestore.entity.ItemEstoqueEntity;
import com.fabrisio.bluestore.entity.ItemVendaEntity;

import java.util.List;
import java.util.UUID;

public interface ItemEstoqueService {

    ItemEstoqueEntity cadastrar(ItemEstoqueDto model);
    ItemEstoqueEntity alterar(UUID id, ItemEstoqueDto model);
    void apagar(UUID id);
    List<ItemEstoqueEntity> listar();
    ItemEstoqueEntity consultar(UUID id);
    ItemEstoqueEntity consultarPorIdProduto(UUID id);
    ItemEstoqueEntity adicionarItem(UUID id, Integer qtd);
    ItemEstoqueEntity removerItem(UUID id, Integer qtd);

}
