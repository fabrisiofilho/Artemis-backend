package com.fabrisio.bluestore.controller;

import com.fabrisio.bluestore.dto.ProdutoDto;
import com.fabrisio.bluestore.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/produto")
@PreAuthorize("isAuthenticated()")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/cadastrar")
    public ProdutoDto cadastro(@RequestBody ProdutoDto dto){
        return new ProdutoDto(produtoService.cadastrar(dto));
    }

    @PutMapping("/alterar/{id}")
    public ProdutoDto alterar(@PathVariable UUID id, @RequestBody ProdutoDto dto) {
        return new ProdutoDto(produtoService.alterar(id, dto));
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable UUID id) {
        produtoService.apagar(id);
    }

    @GetMapping("/listar")
    public List<ProdutoDto> listar() {
        return produtoService.listar().stream().map(ProdutoDto::new).collect(Collectors.toList());
    }

    @GetMapping("/consultar/{id}")
    public ProdutoDto consultar(@PathVariable UUID id) {
        return new ProdutoDto(produtoService.consultar(id));
    }

}
