package com.fabrisio.bluestore.controller;


import com.fabrisio.bluestore.dto.EmpresaDto;
import com.fabrisio.bluestore.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/empresa")
@PreAuthorize("isAuthenticated()")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/cadastrar")
    public EmpresaDto cadastro(@RequestBody EmpresaDto dto){
        return new EmpresaDto(empresaService.cadastrar(dto));
    }

    @PutMapping("/alterar/{id}")
    public EmpresaDto alterar(@PathVariable UUID id, @RequestBody EmpresaDto dto) {
        return new EmpresaDto(empresaService.alterar(id, dto));
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable UUID id) {
        empresaService.apagar(id);
    }

    @GetMapping("/listar")
    public List<EmpresaDto> listar() {
        return empresaService.listar().stream().map(EmpresaDto::new).collect(Collectors.toList());
    }

    @GetMapping("/consultar/{id}")
    public EmpresaDto consultar(@PathVariable UUID id) {
        return new EmpresaDto(empresaService.consultar(id));
    }

}
