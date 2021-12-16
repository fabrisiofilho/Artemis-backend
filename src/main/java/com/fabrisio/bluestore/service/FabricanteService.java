package com.fabrisio.bluestore.service;

import com.fabrisio.bluestore.dto.FabricanteDto;
import com.fabrisio.bluestore.entity.FabricanteEntity;

import java.util.List;
import java.util.UUID;

public interface FabricanteService {

    FabricanteEntity cadastrar(FabricanteDto model);
    FabricanteEntity alterar(UUID id, FabricanteDto model);
    void apagar(UUID id);
    List<FabricanteEntity> listar();
    FabricanteEntity consultar(UUID id);
    List<FabricanteEntity> filtarFabricantes(String query);

}
