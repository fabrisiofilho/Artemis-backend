package com.fabrisio.bluestore.service.impl;

import com.fabrisio.bluestore.dto.EmpresaDto;
import com.fabrisio.bluestore.entity.EmpresaEntity;
import com.fabrisio.bluestore.repository.EmpresaRepository;
import com.fabrisio.bluestore.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public EmpresaEntity cadastrar(EmpresaDto model) {
        return empresaRepository.save(new EmpresaEntity(model.getId(), model.getNome(), model.getCnpj(), LocalDateTime.now(), LocalDateTime.now()));
    }

    @Override
    public EmpresaEntity alterar(UUID id, EmpresaDto model) {
        EmpresaEntity entity = consultar(id);
        entity.atualizar(model);
        return empresaRepository.save(entity);
    }

    @Override
    public void apagar(UUID id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public List<EmpresaEntity> listar() {
        return empresaRepository.findAll();
    }

    @Override
    public EmpresaEntity consultar(UUID id) {
        return empresaRepository.findById(id).orElseThrow();
    }
}
