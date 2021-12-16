package com.fabrisio.bluestore.entity;

import com.fabrisio.bluestore.dto.ProdutoDto;
import com.fabrisio.bluestore.enuns.EnumCategoriaProduto;
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
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @NotNull
    private String nome;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private EnumCategoriaProduto categoria;

    @NotNull
    @Column(name = "id_fabricante")
    private UUID fabricante;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Column(name = "data_da_ultima_atualizacao")
    private LocalDateTime dataDaUltimaAtualizacao;


    public void atualizar(ProdutoDto dto){
        this.nome = dto.getNome();
        this.valor = dto.getValor();
        this.categoria = dto.getCategoria();
        this.fabricante = dto.getIdFabricante();
        this.dataDaUltimaAtualizacao = LocalDateTime.now();
    }
}
