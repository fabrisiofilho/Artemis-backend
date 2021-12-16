package com.fabrisio.bluestore.dto;

import com.fabrisio.bluestore.entity.CaixaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CaixaDto {

    private UUID id;
    private UUID idEmpresa;
    private UUID idFuncionario;
    private BigDecimal valorMovimentado;
    private Integer quantidadeVendas;
    private LocalDateTime aberturaCaixa;
    private LocalDateTime fechamentoCaixa;

    public CaixaDto(CaixaEntity entity) {
        this.id = entity.getId();
        this.idEmpresa = entity.getIdEmpresa();
        this.idFuncionario = entity.getIdFuncionario();
        this.valorMovimentado = entity.getValorMovimentado();
        this.quantidadeVendas = entity.getQuantidadeVendas();
        this.aberturaCaixa = entity.getAberturaCaixa();
        this.fechamentoCaixa = entity.getFechamentoCaixa();
    }
}
