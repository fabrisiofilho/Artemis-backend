package com.fabrisio.bluestore.security.forgotpassword;

import com.fabrisio.bluestore.user.UsuarioEntity;
import com.fabrisio.bluestore.user.UsuarioService;
import com.fabrisio.bluestore.utils.AESUtil;
import com.fabrisio.bluestore.utils.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService{

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AESUtil aesUtil;


    @Override
    public void forgotPasswordProcess(ForgotPasswordDto dto) throws Exception {
        UsuarioEntity user = consultarUsuario(dto.getEmail());
        enviarEmail(user);
        fazerLinkDeRedefinicao(user);
    }

    UsuarioEntity consultarUsuario(String email){
        return usuarioService.consultarPeloEmail(email);
    }

    String fazerLinkDeRedefinicao(UsuarioEntity user) throws Exception {
        String token = aesUtil.Encrypt(user.getUsuario());
        return String.format("http://localhost:8080/resetPassword/{}", token);
    }

    void enviarEmail(UsuarioEntity user){
        Set<String> listDestinatarios = new HashSet<>();
        listDestinatarios.add(user.getEmail());
        StringBuilder body = new StringBuilder("Olá" + user.getUsuario());
        ///sendMailService.enviar(SendMailService.Mensagem.builder().assunto("Redefinição de senha da sua conta ArtisCo").corpo(body.toString()).destinatarios(listDestinatarios).build());
    }

}
