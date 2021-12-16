package com.fabrisio.bluestore.dto;

import com.fabrisio.bluestore.entity.ItemVendaEntity;
import com.fabrisio.bluestore.entity.VendaEntity;
import com.fabrisio.bluestore.enuns.EnumFormaDePagamento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class VendaDto {

    private UUID id;
    private UUID idCaixa;
    private UUID idFuncionario;
    private UUID cliente;
    private Set<ItemVendaEntity> itensVenda = new HashSet<>();
    private BigDecimal valorTotal;
    private EnumFormaDePagamento formaDePagamento;
    private Boolean flag_Ativa;

    public VendaDto(VendaEntity entity) {
        this.id = entity.getId();
        this.idCaixa = entity.getIdCaixa();
        this.idFuncionario = entity.getIdFuncionario();
        this.cliente = entity.getCliente();
        this.itensVenda = entity.getItensVenda();
        this.flag_Ativa = entity.getFlag_ativa();
        this.formaDePagamento = entity.getFormaDePagamento();
        this.valorTotal = entity.getValorTotal();
    }
}
