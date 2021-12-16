package com.fabrisio.bluestore.entity;

import com.fabrisio.bluestore.dto.EmpresaDto;
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
@Table(name = "empresa")
public class EmpresaEntity {

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

    public void atualizar(EmpresaDto dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.cnpj = dto.getCnpj();
        this.dataDaUltimaAtualizacao = LocalDateTime.now();
    }
}
