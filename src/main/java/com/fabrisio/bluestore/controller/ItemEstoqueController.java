package com.fabrisio.bluestore.controller;

import com.fabrisio.bluestore.controller.dto.EstoqueAddOrRemoveDto;
import com.fabrisio.bluestore.dto.ItemEstoqueDto;
import com.fabrisio.bluestore.service.ItemEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/itemestoque")
@PreAuthorize("isAuthenticated()")
public class ItemEstoqueController {

    @Autowired
    private ItemEstoqueService itemEstoqueService;

    @PostMapping("/cadastrar")
    public ItemEstoqueDto cadastro(@RequestBody ItemEstoqueDto dto){
        return new ItemEstoqueDto(itemEstoqueService.cadastrar(dto));
    }

    @PostMapping("/adicionarestoque")
    public ItemEstoqueDto adicionarEstoque(@RequestBody EstoqueAddOrRemoveDto dto){
        return new ItemEstoqueDto(itemEstoqueService.adicionarItem(dto.getId(), dto.getQtd()));
    }

    @PostMapping("/removerestoque")
    public ItemEstoqueDto removerEstoque(@RequestBody EstoqueAddOrRemoveDto dto){
        return new ItemEstoqueDto(itemEstoqueService.removerItem(dto.getId(), dto.getQtd()));
    }

    @PutMapping("/alterar/{id}")
    public ItemEstoqueDto alterar(@PathVariable UUID id, @RequestBody ItemEstoqueDto dto) {
        return new ItemEstoqueDto(itemEstoqueService.alterar(id, dto));
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable UUID id) {
        itemEstoqueService.apagar(id);
    }

    @GetMapping("/listar")
    public List<ItemEstoqueDto> listar() {
        return itemEstoqueService.listar().stream().map(ItemEstoqueDto::new).collect(Collectors.toList());
    }

    @GetMapping("/consultar/{id}")
    public ItemEstoqueDto consultar(@PathVariable UUID id) {
        return new ItemEstoqueDto(itemEstoqueService.consultar(id));
    }


}
