package com.fabrisio.bluestore.controller;

import com.fabrisio.bluestore.controller.dto.QueryDto;
import com.fabrisio.bluestore.dto.FabricanteDto;
import com.fabrisio.bluestore.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/fabricante")
@PreAuthorize("isAuthenticated()")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @PostMapping("/cadastrar")
    public FabricanteDto cadastro(@RequestBody FabricanteDto dto){
        return new FabricanteDto(fabricanteService.cadastrar(dto));
    }

    @PutMapping("/alterar/{id}")
    public FabricanteDto alterar(@PathVariable UUID id, @RequestBody FabricanteDto dto) {
        return new FabricanteDto(fabricanteService.alterar(id, dto));
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable UUID id) {
        fabricanteService.apagar(id);
    }

    @GetMapping("/listar")
    public List<FabricanteDto> listar() {
        return fabricanteService.listar().stream().map(FabricanteDto::new).collect(Collectors.toList());
    }

    @GetMapping("/consultar/{id}")
    public FabricanteDto consultar(@PathVariable UUID id) {
        return new FabricanteDto(fabricanteService.consultar(id));
    }

    @PostMapping("/filtar")
    public List<FabricanteDto> filtarFabricantes(@RequestBody QueryDto query) {
        return fabricanteService.filtarFabricantes(query.getQuery()).stream().map(FabricanteDto::new).collect(Collectors.toList());
    }

}
