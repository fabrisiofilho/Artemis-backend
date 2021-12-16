package com.fabrisio.bluestore.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class EstoqueAddOrRemoveDto {

    private UUID id;
    private Integer Qtd;

}
