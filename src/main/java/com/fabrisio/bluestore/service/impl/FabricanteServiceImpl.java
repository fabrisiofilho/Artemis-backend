package com.fabrisio.bluestore.service.impl;

import com.fabrisio.bluestore.dto.FabricanteDto;
import com.fabrisio.bluestore.entity.FabricanteEntity;
import com.fabrisio.bluestore.repository.FabricanteRepository;
import com.fabrisio.bluestore.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class FabricanteServiceImpl implements FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public FabricanteEntity cadastrar(FabricanteDto model) {
        return fabricanteRepository.save(new FabricanteEntity(model.getId(), model.getNome(), model.getCnpj(), LocalDateTime.now(), LocalDateTime.now()));
    }

    @Override
    public FabricanteEntity alterar(UUID id, FabricanteDto model) {
        FabricanteEntity entity = consultar(id);
        entity.atualizar(model);
        return fabricanteRepository.save(entity);
    }

    @Override
    public void apagar(UUID id) {
        fabricanteRepository.deleteById(id);
    }

    @Override
    public List<FabricanteEntity> listar() {
        return fabricanteRepository.findAll();
    }

    @Override
    public FabricanteEntity consultar(UUID id) {
        return fabricanteRepository.findById(id).orElseThrow();
    }

    @Override
    public List<FabricanteEntity> filtarFabricantes(String query) {
        return fabricanteRepository.findByNomeIsContaining(query);
    }
}
