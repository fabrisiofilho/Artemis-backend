package com.fabrisio.bluestore.user;

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
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(unique = true)
    private String usuario;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String senha;

    @Column(name = "id_funcionario")
    private UUID idFuncionario;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Column(name = "data_da_ultima_atualizacao")
    private LocalDateTime dataDaUltimaAtualizacao;

    void atualizar(UsuarioDto dto) {
        this.id = dto.getId();
        this.usuario = dto.getUsuario();
        this.email = dto.getEmail();
        this.senha = dto.getSenha();
        this.idFuncionario = dto.getIdFuncionario();
        this.dataDaUltimaAtualizacao = LocalDateTime.now();
    }

}
