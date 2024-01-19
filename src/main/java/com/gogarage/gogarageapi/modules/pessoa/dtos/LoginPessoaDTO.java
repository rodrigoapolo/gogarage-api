package com.gogarage.gogarageapi.modules.pessoa.dtos;

import com.gogarage.gogarageapi.modules.pessoa.PessoaModel;
import lombok.Data;

@Data
public class LoginPessoaDTO {
    private String email;
    private String password;

    public LoginPessoaDTO() {
    }

    public LoginPessoaDTO(PessoaModel pessoaModel) {
        this.email = pessoaModel.getEmail();
        this.password = pessoaModel.getPassword();
    }

}
