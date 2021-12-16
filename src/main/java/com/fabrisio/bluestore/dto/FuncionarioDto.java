package com.fabrisio.bluestore.dto;

import com.fabrisio.bluestore.entity.FuncionarioEntity;
import com.fabrisio.bluestore.enuns.EnumCargoFuncionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDto {

    private UUID id;
    private String nome;
    private String sobrenome;
    private UUID idEmpresa;
    private EnumCargoFuncionario cargo;
    private LocalDateTime dataAdmissao;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public FuncionarioDto(FuncionarioEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.sobrenome = entity.getSobrenome();
        this.idEmpresa = entity.getIdEmpresa();
        this.cargo = entity.getCargo();
        this.dataAdmissao = entity.getDataAdmissao();
        this.cpf = entity.getCpf();
        this.dataNascimento = entity.getDataNascimento();
        this.email = entity.getEmail();
        this.telefone = entity.getTelefone();
    }
}
