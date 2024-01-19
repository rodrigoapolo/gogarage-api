package com.gogarage.gogarageapi.modules.pessoa.dtos;

import lombok.Data;

@Data
public class UpdatePessoaDTO {

    private Long id;
    private String name;
    private String phone;
}
