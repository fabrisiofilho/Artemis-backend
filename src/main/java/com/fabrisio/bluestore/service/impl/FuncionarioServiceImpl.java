package com.fabrisio.bluestore.service.impl;

import com.fabrisio.bluestore.dto.FuncionarioDto;
import com.fabrisio.bluestore.entity.FuncionarioEntity;
import com.fabrisio.bluestore.repository.FuncionarioRepository;
import com.fabrisio.bluestore.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public FuncionarioEntity cadastrar(FuncionarioDto model) {
        return funcionarioRepository.save(new FuncionarioEntity(model.getId(), model.getNome(), model.getSobrenome()
                , model.getIdEmpresa(), model.getCargo(), LocalDateTime.now(), model.getCpf(), model.getDataNascimento()
                , model.getTelefone(), model.getEmail(), true, LocalDateTime.now(), LocalDateTime.now()));
    }

    @Override
    public FuncionarioEntity alterar(UUID id, FuncionarioDto model) {
        FuncionarioEntity entity = consultar(id);
        entity.atualizar(model);
        return funcionarioRepository.save(entity);
    }

    @Override
    public void apagar(UUID id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public List<FuncionarioEntity> listar() {
        return funcionarioRepository.findAll();
    }

    @Override
    public FuncionarioEntity consultar(UUID id) {
        return funcionarioRepository.findById(id).orElseThrow();
    }

    @Override
    public FuncionarioEntity consultarPorEmail(String email) {
        return funcionarioRepository.findByEmail(email).orElseThrow();
    }
}
