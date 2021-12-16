package com.fabrisio.bluestore.user;

import com.fabrisio.bluestore.security.resetpassword.ResetPasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioEntity cadastrar(UsuarioDto model) {
        return usuarioRepository.save(new UsuarioEntity(model.getId(),model.getUsuario() ,model.getEmail(),
                passwordEncoder.encode(model.getSenha()), model.getIdFuncionario(), LocalDateTime.now(), LocalDateTime.now()));
    }

    @Override
    public UsuarioEntity alterar(UUID id, UsuarioDto model) {
        UsuarioEntity entity = consultar(id);
        model.setSenha(passwordEncoder.encode(model.getSenha()));
        entity.atualizar(model);
        return usuarioRepository.save(entity);
    }

    @Override
    public UsuarioEntity alterarSenha(UUID id, ResetPasswordDto model){
        UsuarioEntity entity = consultar(id);
        entity.setSenha(passwordEncoder.encode(model.getSenha()));
        return usuarioRepository.save(entity);
    }

    @Override
    public void apagar(UUID id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioEntity> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity consultar(UUID id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

}
