package com.fabrisio.bluestore.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDto {

    private UUID id;
    private String usuario;
    private String email;
    private String senha;
    private UUID idFuncionario;


    public UsuarioDto(UUID id, String usuario, String email, String senha, UUID idFuncionario) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.idFuncionario = idFuncionario;
    }

    public UsuarioDto(UsuarioEntity entity) {
        this.id = entity.getId();
        this.usuario = entity.getUsuario();
        this.email = entity.getEmail();
        this.senha = entity.getSenha();
        this.idFuncionario = entity.getIdFuncionario();
    }
}
