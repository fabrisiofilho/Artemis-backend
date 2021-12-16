package com.fabrisio.bluestore.dto;

import com.fabrisio.bluestore.entity.FabricanteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class FabricanteDto {

    private UUID id;
    private String nome;
    private String cnpj;

    public FabricanteDto(FabricanteEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cnpj = entity.getCnpj();
    }
}
