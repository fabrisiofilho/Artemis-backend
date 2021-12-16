package com.fabrisio.bluestore.service.impl;

import com.fabrisio.bluestore.dto.CaixaDto;
import com.fabrisio.bluestore.entity.CaixaEntity;
import com.fabrisio.bluestore.repository.CaixaRepository;
import com.fabrisio.bluestore.service.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CaixaServiceImpl implements CaixaService {

    @Autowired
    private CaixaRepository caixaRepository;

    @Override
    public CaixaEntity cadastrar(CaixaDto model) {
        return caixaRepository.save(new CaixaEntity(model.getId(), model.getIdEmpresa(), model.getIdFuncionario(),
                BigDecimal.ZERO, 0, LocalDateTime.now(), null, LocalDateTime.now(), LocalDateTime.now()));
    }

    @Override
    public CaixaEntity alterar(UUID id, CaixaDto model) {
        CaixaEntity entity = consultar(id);
        entity.atualizar(model);
        return caixaRepository.save(entity);
    }

    @Override
    public void apagar(UUID id) {
        caixaRepository.deleteById(id);
    }

    @Override
    public List<CaixaEntity> listar() {
        return caixaRepository.findAll();
    }

    @Override
    public CaixaEntity consultar(UUID id) {
        return caixaRepository.findById(id).orElseThrow();
    }
}
