package com.fabrisio.bluestore.security.authserver;

import com.fabrisio.bluestore.user.UsuarioEntity;
import com.fabrisio.bluestore.user.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioRepository
                .findByUsuario(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com e-mail informado"));
        return new AuthUser(usuario);
    }
}
