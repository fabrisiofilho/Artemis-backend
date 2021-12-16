package com.fabrisio.bluestore.entity;

import com.fabrisio.bluestore.dto.FuncionarioDto;
import com.fabrisio.bluestore.enuns.EnumCargoFuncionario;
import javax.validation.constraints.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionario")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @NotNull
    private String nome;

    @NotNull
    private String sobrenome;

    @NotNull
    @Column(name = "id_empresa")
    private UUID idEmpresa;

    @NotNull
    private EnumCargoFuncionario cargo;

    @NotNull
    @Column(name = "data_admissao")
    private LocalDateTime dataAdmissao;

    @NotNull
    private String cpf;

    @NotNull
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String telefone;

    @Column(name = "flag_ativo")
    private Boolean flagAtivo;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Column(name = "data_da_ultima_atualizacao")
    private LocalDateTime dataDaUltimaAtualizacao;

    public void atualizar(FuncionarioDto dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.sobrenome = dto.getSobrenome();
        this.idEmpresa = dto.getIdEmpresa();
        this.cargo = dto.getCargo();
        this.dataAdmissao = dto.getDataAdmissao();
        this.cpf = dto.getCpf();
        this.dataNascimento = dto.getDataNascimento();
        this.email = dto.getEmail();
        this.telefone = dto.getTelefone();
        this.dataDaUltimaAtualizacao = LocalDateTime.now();
    }

    public void desativar(){
        this.flagAtivo = false;
    }

    public void ativar(){
        this.flagAtivo = true;
    }
}
