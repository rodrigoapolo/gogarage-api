package com.gogarage.gogarageapi.modules.pessoa.dtos;

import com.gogarage.gogarageapi.modules.pessoa.PessoaModel;
import lombok.Data;

@Data
public class EmailPessoaDTO {

    private String email;

    public EmailPessoaDTO() {
    }

    public EmailPessoaDTO(PessoaModel pessoaModel) {
        this.email = pessoaModel.getEmail();
    }
}
