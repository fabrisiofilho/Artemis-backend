package com.fabrisio.bluestore.entity;

import com.fabrisio.bluestore.dto.FabricanteDto;
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
@Table(name = "fabricante")
public class FabricanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @NotNull
    private String nome;

    @NotNull
    private String cnpj;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Column(name = "data_da_ultima_atualizacao")
    private LocalDateTime dataDaUltimaAtualizacao;

    public void atualizar(FabricanteDto dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.dataDaUltimaAtualizacao = LocalDateTime.now();
    }
}
