package com.fabrisio.bluestore.controller;

import com.fabrisio.bluestore.dto.VendaDto;
import com.fabrisio.bluestore.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/venda")
@PreAuthorize("isAuthenticated()")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/cadastrar")
    public VendaDto cadastro(@RequestBody VendaDto dto){
        return new VendaDto(vendaService.cadastrar(dto));
    }

    @PutMapping("/alterar/{id}")
    public VendaDto alterar(@PathVariable UUID id, @RequestBody VendaDto dto) {
        return new VendaDto(vendaService.alterar(id, dto));
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable UUID id) {
        vendaService.apagar(id);
    }

    @GetMapping("/listar")
    public List<VendaDto> listar() {
        return vendaService.listar().stream().map(VendaDto::new).collect(Collectors.toList());
    }

    @GetMapping("/consultar/{id}")
    public VendaDto consultar(@PathVariable UUID id) {
        return new VendaDto(vendaService.consultar(id));
    }

}
