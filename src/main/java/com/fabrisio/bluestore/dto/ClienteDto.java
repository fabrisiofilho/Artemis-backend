package com.fabrisio.bluestore.dto;

import com.fabrisio.bluestore.entity.ClienteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class ClienteDto {

    private UUID id;
    private String nome;
    private String cpf;
    private LocalDateTime dataUltimaCompra;

    public ClienteDto(ClienteEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cpf = entity.getCpf();
        this.dataUltimaCompra = entity.getDataUltimaCompra();
    }
}
