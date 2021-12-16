package com.fabrisio.bluestore.dto;

import com.fabrisio.bluestore.entity.ItemEstoqueEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class ItemEstoqueDto {

    private UUID id;
    private UUID idProduto;
    private Integer qtdEstoque;

    public ItemEstoqueDto(ItemEstoqueEntity entity) {
        this.id = entity.getId();
        this.idProduto = entity.getIdProduto();
        this.qtdEstoque = entity.getQtdEstoque();
    }
}
