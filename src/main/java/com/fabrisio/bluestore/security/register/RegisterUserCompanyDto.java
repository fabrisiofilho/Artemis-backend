package com.fabrisio.bluestore.security.register;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RegisterUserCompanyDto {

    private String usuario;
    private String senha;
    private String email;
    private String nomeEmpresa;
    private String cnpj;
    private String nome;
    private String sobrenome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;

}
