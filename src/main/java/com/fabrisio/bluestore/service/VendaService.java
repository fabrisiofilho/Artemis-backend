package com.fabrisio.bluestore.service;

import com.fabrisio.bluestore.dto.VendaDto;
import com.fabrisio.bluestore.entity.VendaEntity;

import java.util.List;
import java.util.UUID;

public interface VendaService {

    VendaEntity cadastrar(VendaDto model);
    VendaEntity alterar(UUID id, VendaDto model);
    void apagar(UUID id);
    List<VendaEntity> listar();
    VendaEntity consultar(UUID id);
    VendaEntity fecharVenda(VendaDto model);
}
