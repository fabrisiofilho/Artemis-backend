package com.fabrisio.bluestore.security.register;

import com.fabrisio.bluestore.enuns.EnumCargoFuncionario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RegisterUserEmployeeDto {

    private String usuario;
    private String senha;
    private String email;
    private String nomeEmpresa;
    private String cnpj;
    private String nome;
    private String sobrenome;
    private EnumCargoFuncionario cargo;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;


}
