package com.fabrisio.bluestore.service;

import com.fabrisio.bluestore.dto.ClienteDto;
import com.fabrisio.bluestore.entity.ClienteEntity;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteEntity cadastrar(ClienteDto model);
    ClienteEntity alterar(UUID id, ClienteDto model);
    void apagar(UUID id);
    List<ClienteEntity> listar();
    ClienteEntity consultar(UUID id);
}
