package com.fabrisio.bluestore.entity;

import com.fabrisio.bluestore.dto.ClienteDto;
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
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @NotNull
    private String nome;

    @NotNull
    private String cpf;

    @Column(name = "data_ultima_compra")
    private LocalDateTime dataUltimaCompra;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Column(name = "data_da_ultima_atualizacao")
    private LocalDateTime dataDaUltimaAtualizacao;

    public void atualizar(ClienteDto dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.cpf = dto.getCpf();
        this.dataUltimaCompra = dto.getDataUltimaCompra();
        this.dataDaUltimaAtualizacao = LocalDateTime.now();
    }
}
