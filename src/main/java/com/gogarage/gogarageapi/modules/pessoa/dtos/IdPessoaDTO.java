package com.gogarage.gogarageapi.modules.pessoa.dtos;

import com.gogarage.gogarageapi.modules.pessoa.PessoaModel;
import lombok.Data;

@Data
public class IdPessoaDTO {
    private Long id;

    public IdPessoaDTO() {
    }

    public IdPessoaDTO(PessoaModel obj) {
        this.id = obj.getId();
    }
}
