package com.fabrisio.bluestore.controller;

import com.fabrisio.bluestore.dto.ClienteDto;
import com.fabrisio.bluestore.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
@PreAuthorize("isAuthenticated()")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastrar")
    public ClienteDto cadastro(@RequestBody ClienteDto dto){
        return new ClienteDto(clienteService.cadastrar(dto));
    }

    @PutMapping("/alterar/{id}")
    public ClienteDto alterar(@PathVariable UUID id, @RequestBody ClienteDto dto) {
        return new ClienteDto(clienteService.alterar(id, dto));
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable UUID id) {
        clienteService.apagar(id);
    }

    @GetMapping("/listar")
    public List<ClienteDto> listar() {
        return clienteService.listar().stream().map(ClienteDto::new).collect(Collectors.toList());
    }

    @GetMapping("/consultar/{id}")
    public ClienteDto consultar(@PathVariable UUID id) {
        return new ClienteDto(clienteService.consultar(id));
    }

}
