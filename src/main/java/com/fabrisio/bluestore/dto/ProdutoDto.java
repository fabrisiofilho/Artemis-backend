package com.fabrisio.bluestore.dto;

import com.fabrisio.bluestore.entity.ProdutoEntity;
import com.fabrisio.bluestore.enuns.EnumCategoriaProduto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDto {

    private UUID id;
    private String nome;
    private BigDecimal valor;
    private EnumCategoriaProduto categoria;
    private UUID idFabricante;

    public ProdutoDto(ProdutoEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.valor = entity.getValor();
        this.categoria = entity.getCategoria();
        this.idFabricante = entity.getFabricante();
    }
}
