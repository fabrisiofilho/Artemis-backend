package com.fabrisio.bluestore.dto;

import com.fabrisio.bluestore.entity.MovimentacaoEstoqueEntity;
import com.fabrisio.bluestore.enuns.EnumTipoMovimentacao;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovimentacaoEstoqueDto {

    private UUID id;
    private UUID idItemEstoque;
    private Integer qtd;
    private EnumTipoMovimentacao movimentacao;
    private LocalDateTime data;

    public MovimentacaoEstoqueDto(MovimentacaoEstoqueEntity entity) {

        this.id = entity.getId();
        this.idItemEstoque = entity.getIdItemEstoque();
        this.qtd = entity.getQtd();
        this.movimentacao = entity.getMovimentacao();
        this.data = entity.getData();

    }
}
