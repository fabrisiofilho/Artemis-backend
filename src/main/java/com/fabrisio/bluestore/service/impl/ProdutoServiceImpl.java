package com.fabrisio.bluestore.service.impl;

import com.fabrisio.bluestore.dto.ProdutoDto;
import com.fabrisio.bluestore.entity.ProdutoEntity;
import com.fabrisio.bluestore.repository.ProdutoRepository;
import com.fabrisio.bluestore.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public ProdutoEntity cadastrar(ProdutoDto dto) {
        return produtoRepository.save(new ProdutoEntity(dto.getId(), dto.getNome(),
                dto.getValor(), dto.getCategoria(), dto.getIdFabricante(), LocalDateTime.now(), LocalDateTime.now()));
    }

    @Override
    public ProdutoEntity alterar(UUID id, ProdutoDto model) {
        ProdutoEntity entity = consultar(id);
        entity.atualizar(model);
        return produtoRepository.save(entity);
    }

    @Override
    public void apagar(UUID id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public List<ProdutoEntity> listar() {
        return produtoRepository.findAll();
    }

    @Override
    public ProdutoEntity consultar(UUID id) {
        return produtoRepository.findById(id).orElseThrow();
    }
}
