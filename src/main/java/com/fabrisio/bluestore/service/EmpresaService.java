package com.fabrisio.bluestore.service;

import com.fabrisio.bluestore.dto.EmpresaDto;
import com.fabrisio.bluestore.entity.EmpresaEntity;

import java.util.List;
import java.util.UUID;

public interface EmpresaService {

    EmpresaEntity cadastrar(EmpresaDto model);
    EmpresaEntity alterar(UUID id, EmpresaDto model);
    void apagar(UUID id);
    List<EmpresaEntity> listar();
    EmpresaEntity consultar(UUID id);

}
