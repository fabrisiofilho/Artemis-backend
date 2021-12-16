package com.fabrisio.bluestore.controller;

import com.fabrisio.bluestore.dto.ItemVendaDto;
import com.fabrisio.bluestore.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/itemvenda")
@PreAuthorize("isAuthenticated()")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @PostMapping("/cadastrar")
    public ItemVendaDto cadastro(@RequestBody ItemVendaDto dto){
        return new ItemVendaDto(itemVendaService.cadastrar(dto));
    }

    @PutMapping("/alterar/{id}")
    public ItemVendaDto alterar(@PathVariable UUID id, @RequestBody ItemVendaDto dto) {
        return new ItemVendaDto(itemVendaService.alterar(id, dto));
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable UUID id) {
        itemVendaService.apagar(id);
    }

    @GetMapping("/listar")
    public List<ItemVendaDto> listar() {
        return itemVendaService.listar().stream().map(ItemVendaDto::new).collect(Collectors.toList());
    }

    @GetMapping("/consultar/{id}")
    public ItemVendaDto consultar(@PathVariable UUID id) {
        return new ItemVendaDto(itemVendaService.consultar(id));
    }

}
