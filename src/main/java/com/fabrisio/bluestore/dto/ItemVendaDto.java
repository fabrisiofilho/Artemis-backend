package com.fabrisio.bluestore.dto;

import com.fabrisio.bluestore.entity.ItemVendaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ItemVendaDto {

    private UUID id;
    private UUID idProduto;
    private Integer qtd;
    private BigDecimal valorTotal;
    private UUID venda_id;
    private Integer desconto;

    public ItemVendaDto(ItemVendaEntity entity) {
        this.id = entity.getId();
        this.idProduto = entity.getIdProduto();
        this.qtd = entity.getQtd();
        this.valorTotal = entity.getValorTotal();
        this.venda_id = entity.getVenda_id();
        this.desconto = entity.getDesconto();
    }
}
