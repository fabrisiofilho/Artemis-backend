package com.fabrisio.bluestore.entity;

import com.fabrisio.bluestore.dto.MovimentacaoEstoqueDto;
import com.fabrisio.bluestore.enuns.EnumTipoMovimentacao;
import javax.validation.constraints.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movimentacaoestoque")
public class MovimentacaoEstoqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "id_item_estoque")
    private UUID idItemEstoque;

    @NotNull
    private Integer qtd;

    @NotNull
    @Column(name = "tipo")
    private EnumTipoMovimentacao movimentacao;

    @NotNull
    private LocalDateTime data;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Column(name = "data_da_ultima_atualizacao")
    private LocalDateTime dataDaUltimaAtualizacao;

    public void atualizar(MovimentacaoEstoqueDto dto) {
        this.id = dto.getId();
        this.idItemEstoque = dto.getIdItemEstoque();
        this.qtd = dto.getQtd();
        this.movimentacao = dto.getMovimentacao();
        this.data = dto.getData();
        this.dataDaUltimaAtualizacao = LocalDateTime.now();
    }
}
