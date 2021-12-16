package com.fabrisio.bluestore.service.impl;

import com.fabrisio.bluestore.dto.ClienteDto;
import com.fabrisio.bluestore.entity.ClienteEntity;
import com.fabrisio.bluestore.repository.ClienteRepository;
import com.fabrisio.bluestore.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteEntity cadastrar(ClienteDto model) {
        return clienteRepository.save(new ClienteEntity(model.getId(), model.getNome(),
                model.getCpf(), model.getDataUltimaCompra(), LocalDateTime.now(), LocalDateTime.now()));
    }

    @Override
    public ClienteEntity alterar(UUID id, ClienteDto model) {
        ClienteEntity entity = consultar(id);
        entity.atualizar(model);
        return clienteRepository.save(entity);
    }

    @Override
    public void apagar(UUID id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteEntity> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity consultar(UUID id) {
        return clienteRepository.findById(id).orElseThrow();
    }
}
