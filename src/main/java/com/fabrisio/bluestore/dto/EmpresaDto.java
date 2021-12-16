package com.fabrisio.bluestore.dto;

import com.fabrisio.bluestore.entity.EmpresaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDto {

    private UUID id;
    private String nome;
    private String cnpj;

    public EmpresaDto(EmpresaEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cnpj = entity.getCnpj();
    }
}
