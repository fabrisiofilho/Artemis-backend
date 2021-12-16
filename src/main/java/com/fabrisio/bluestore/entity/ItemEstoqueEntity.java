package com.fabrisio.bluestore.entity;

import com.fabrisio.bluestore.dto.ItemEstoqueDto;
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
@Table(name = "itemestoque")
public class ItemEstoqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "id_produto")
    private UUID idProduto;

    @NotNull
    @Column(name = "qtd_estoque")
    private Integer qtdEstoque;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Column(name = "data_da_ultima_atualizacao")
    private LocalDateTime dataDaUltimaAtualizacao;

    public void atualizar(ItemEstoqueDto dto) {
        this.id = dto.getId();
        this.idProduto = dto.getIdProduto();
        this.qtdEstoque = dto.getQtdEstoque();
        this.dataDaUltimaAtualizacao = LocalDateTime.now();
    }

    public void removerItensNoEstoque(Integer qtdRetirar){
        this.qtdEstoque -= qtdRetirar;
    }

    public void adicionarItensNoEstoque(Integer qtdAdicionar){
        this.qtdEstoque += qtdAdicionar;
    }
}
