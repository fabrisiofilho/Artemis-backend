package com.fabrisio.bluestore.entity;

import com.fabrisio.bluestore.dto.CaixaDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "caixa")
public class CaixaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "id_empresa")
    private UUID idEmpresa;

    @NotNull
    @Column(name = "id_funcionario")
    private UUID idFuncionario;

    @NotNull
    @Column(name = "valor_movimentado")
    private BigDecimal valorMovimentado;

    @Column(name = "quantidade_vendas")
    private Integer quantidadeVendas;

    @NotNull
    @Column(name = "abertura_caixa")
    private LocalDateTime aberturaCaixa;

    @Column(name = "fechamento_caixa")
    private LocalDateTime fechamentoCaixa;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Column(name = "data_da_ultima_atualizacao")
    private LocalDateTime dataDaUltimaAtualizacao;


    public void atualizar(CaixaDto dto) {
        this.id = dto.getId();
        this.idEmpresa = dto.getIdEmpresa();
        this.idFuncionario = dto.getIdFuncionario();
        this.valorMovimentado = dto.getValorMovimentado();
        this.quantidadeVendas = dto.getQuantidadeVendas();
        this.aberturaCaixa = dto.getAberturaCaixa();
        this.fechamentoCaixa = dto.getFechamentoCaixa();
        this.dataDaUltimaAtualizacao = LocalDateTime.now();
    }

}
