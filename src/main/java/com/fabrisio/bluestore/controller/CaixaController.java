package com.fabrisio.bluestore.controller;

import com.fabrisio.bluestore.dto.CaixaDto;
import com.fabrisio.bluestore.dto.EmpresaDto;
import com.fabrisio.bluestore.service.CaixaService;
import com.fabrisio.bluestore.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/caixa")
@PreAuthorize("isAuthenticated()")
public class CaixaController {

    @Autowired
    private CaixaService caixaService;

    @PostMapping("/cadastrar")
    public CaixaDto cadastro(@RequestBody CaixaDto dto){
        return new CaixaDto(caixaService.cadastrar(dto));
    }

    @PutMapping("/alterar/{id}")
    public CaixaDto alterar(@PathVariable UUID id, @RequestBody CaixaDto dto) {
        return new CaixaDto(caixaService.alterar(id, dto));
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable UUID id) {
        caixaService.apagar(id);
    }

    @GetMapping("/listar")
    public List<CaixaDto> listar() {
        return caixaService.listar().stream().map(CaixaDto::new).collect(Collectors.toList());
    }

    @GetMapping("/consultar/{id}")
    public CaixaDto consultar(@PathVariable UUID id) {
        return new CaixaDto(caixaService.consultar(id));
    }


}
