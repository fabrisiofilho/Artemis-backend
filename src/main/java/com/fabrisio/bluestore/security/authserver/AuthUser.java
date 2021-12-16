package com.fabrisio.bluestore.security.authserver;

import com.fabrisio.bluestore.user.UsuarioEntity;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Getter
public class AuthUser extends User {

    private String nomeCompleto;
    private String email;

    public AuthUser(UsuarioEntity usuario){
        super(usuario.getUsuario(), usuario.getSenha(), Collections.emptyList());
        this.nomeCompleto = usuario.getUsuario();
        this.email = usuario.getEmail();
    }

}
