package com.fabrisio.bluestore.user;

import com.fabrisio.bluestore.security.resetpassword.ResetPasswordDto;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {

    UsuarioEntity cadastrar(UsuarioDto model);
    UsuarioEntity alterar(UUID id, UsuarioDto model);
    void apagar(UUID id);
    List<UsuarioEntity> listar();
    UsuarioEntity consultar(UUID id);
    UsuarioEntity alterarSenha(UUID id, ResetPasswordDto model);

}
