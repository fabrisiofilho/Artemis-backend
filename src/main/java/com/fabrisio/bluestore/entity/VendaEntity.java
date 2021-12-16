package com.fabrisio.bluestore.entity;

import com.fabrisio.bluestore.dto.VendaDto;
import com.fabrisio.bluestore.enuns.EnumFormaDePagamento;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "venda")
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "id_caixa")
    private UUID idCaixa;

    @NotNull
    @Column(name = "id_funcionario")
    private UUID idFuncionario;

    @NotNull
    @Column(name = "id_cliente")
    private UUID cliente;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id")
    private Set<ItemVendaEntity> itensVenda = new HashSet<>();

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "forma_de_pagamento")
    private EnumFormaDePagamento formaDePagamento;

    @Column(name = "flag_ativa")
    private Boolean flag_ativa;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Column(name = "data_da_ultima_atualizacao")
    private LocalDateTime dataDaUltimaAtualizacao;

    public void atualizar(VendaDto dto) {
        this.id = dto.getId();
        this.idCaixa = dto.getIdCaixa();
        this.idFuncionario = dto.getIdFuncionario();
        this.cliente = dto.getCliente();
        this.itensVenda = dto.getItensVenda();
        this.valorTotal = dto.getValorTotal();
        this.formaDePagamento = dto.getFormaDePagamento();
        this.flag_ativa = dto.getFlag_Ativa();
        this.dataDaUltimaAtualizacao = LocalDateTime.now();
    }

    public void finalizarVenda(){
        this.flag_ativa = false;
    }

    public boolean isActivated(){
       return this.flag_ativa;
    }

    public void atualizarValorTotalAdicionar(BigDecimal valorAdicional){
        this.valorTotal = valorTotal.add(valorAdicional);
    }

    public void atualizarValorTotalRemover(BigDecimal valorRetirada){
        this.valorTotal = valorTotal.subtract(valorRetirada);
    }
}
