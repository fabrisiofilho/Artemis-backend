package com.fabrisio.bluestore.entity;

import com.fabrisio.bluestore.dto.ItemVendaDto;
import javax.validation.constraints.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "itemvenda")
public class ItemVendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "id_produto")
    private UUID idProduto;

    @NotNull
    private Integer qtd;

    @NotNull
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @NotNull
    private UUID venda_id;

    @NotNull
    private Integer desconto;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Column(name = "data_da_ultima_atualizacao")
    private LocalDateTime dataDaUltimaAtualizacao;

    public void atualizar(ItemVendaDto dto) {
        this.id = dto.getId();
        this.idProduto = dto.getIdProduto();
        this.qtd = dto.getQtd();
        this.valorTotal = dto.getValorTotal();
        this.desconto = dto.getDesconto();
        this.venda_id = dto.getVenda_id();
        this.dataDaUltimaAtualizacao = LocalDateTime.now();
    }
}
