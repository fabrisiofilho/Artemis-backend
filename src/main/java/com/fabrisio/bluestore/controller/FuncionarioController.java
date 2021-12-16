package com.fabrisio.bluestore.controller;

import com.fabrisio.bluestore.dto.FuncionarioDto;
import com.fabrisio.bluestore.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/funcionario")
@PreAuthorize("isAuthenticated()")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/cadastrar")
    public FuncionarioDto cadastro(@RequestBody FuncionarioDto dto){
        return new FuncionarioDto(funcionarioService.cadastrar(dto));
    }

    @PutMapping("/alterar/{id}")
    public FuncionarioDto alterar(@PathVariable UUID id, @RequestBody FuncionarioDto dto) {
        return new FuncionarioDto(funcionarioService.alterar(id, dto));
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable UUID id) {
        funcionarioService.apagar(id);
    }

    @GetMapping("/listar")
    public List<FuncionarioDto> listar() {
        return funcionarioService.listar().stream().map(FuncionarioDto::new).collect(Collectors.toList());
    }

    @GetMapping("/consultar/{id}")
    public FuncionarioDto consultar(@PathVariable UUID id) {
        return new FuncionarioDto(funcionarioService.consultar(id));
    }

}
