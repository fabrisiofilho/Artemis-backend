package com.fabrisio.bluestore.utils;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

public interface SendMailService {

    void enviar(Mensagem mensagem);

    @Getter
    @Builder
    class Mensagem{

        private Set<String> destinatarios;
        private String assunto;
        private String corpo;

    }

}
