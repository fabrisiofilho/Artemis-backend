package com.fabrisio.bluestore.service;

import com.fabrisio.bluestore.dto.ItemVendaDto;
import com.fabrisio.bluestore.entity.ItemVendaEntity;

import java.util.List;
import java.util.UUID;

public interface ItemVendaService {

    ItemVendaEntity cadastrar(ItemVendaDto model);
    ItemVendaEntity alterar(UUID id, ItemVendaDto model);
    void apagar(UUID id);
    List<ItemVendaEntity> listar();
    ItemVendaEntity consultar(UUID id);

}
