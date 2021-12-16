package com.fabrisio.bluestore.service;

import com.fabrisio.bluestore.dto.FuncionarioDto;
import com.fabrisio.bluestore.entity.FuncionarioEntity;

import java.util.List;
import java.util.UUID;

public interface FuncionarioService {

    FuncionarioEntity cadastrar(FuncionarioDto model);
    FuncionarioEntity alterar(UUID id, FuncionarioDto model);
    void apagar(UUID id);
    List<FuncionarioEntity> listar();
    FuncionarioEntity consultar(UUID id);
    FuncionarioEntity consultarPorEmail(String email);

}
