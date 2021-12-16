package com.fabrisio.bluestore.service.impl;

import com.fabrisio.bluestore.dto.VendaDto;
import com.fabrisio.bluestore.entity.VendaEntity;
import com.fabrisio.bluestore.repository.VendaRepository;
import com.fabrisio.bluestore.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Override
    public VendaEntity cadastrar(VendaDto model) {
        return vendaRepository.save(new VendaEntity(model.getId(), model.getIdCaixa(), model.getIdFuncionario(),
                model.getCliente(), model.getItensVenda(), model.getValorTotal(), model.getFormaDePagamento(),
                model.getFlag_Ativa(), LocalDateTime.now(), LocalDateTime.now()));
    }

    @Override
    public VendaEntity alterar(UUID id, VendaDto model) {
        VendaEntity entity = consultar(id);
        entity.atualizar(model);
        return vendaRepository.save(entity);
    }

    @Override
    public void apagar(UUID id) {
        vendaRepository.deleteById(id);
    }

    @Override
    public List<VendaEntity> listar() {
        return vendaRepository.findAll();
    }

    @Override
    public VendaEntity consultar(UUID id) {
        return vendaRepository.findById(id).orElseThrow();
    }

    @Override
    public VendaEntity fecharVenda(VendaDto model) {
        VendaEntity entity = consultar(model.getId());
        entity.finalizarVenda();
        return vendaRepository.save(entity);
    }
}
