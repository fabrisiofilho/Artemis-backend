package com.fabrisio.bluestore.controller;

import com.fabrisio.bluestore.dto.FuncionarioDto;
import com.fabrisio.bluestore.dto.MovimentacaoEstoqueDto;
import com.fabrisio.bluestore.entity.MovimentacaoEstoqueEntity;
import com.fabrisio.bluestore.repository.MovimentacaoEstoqueRepository;
import com.fabrisio.bluestore.service.MovimentacaoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/movimentacao")
@PreAuthorize("isAuthenticated()")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    @GetMapping("/listar")
    public List<MovimentacaoEstoqueDto> listar() {
        return movimentacaoEstoqueService.listar().stream().map(MovimentacaoEstoqueDto::new).collect(Collectors.toList());
    }

    @GetMapping("/consultar/{id}")
    public MovimentacaoEstoqueDto consultar(@PathVariable UUID id) {
        return new MovimentacaoEstoqueDto(movimentacaoEstoqueService.consultar(id));
    }

}
