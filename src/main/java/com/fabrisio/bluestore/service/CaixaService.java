package com.fabrisio.bluestore.service;

import com.fabrisio.bluestore.dto.CaixaDto;
import com.fabrisio.bluestore.entity.CaixaEntity;

import java.util.List;
import java.util.UUID;

public interface CaixaService {

    CaixaEntity cadastrar(CaixaDto model);
    CaixaEntity alterar(UUID id, CaixaDto model);
    void apagar(UUID id);
    List<CaixaEntity> listar();
    CaixaEntity consultar(UUID id);

}
