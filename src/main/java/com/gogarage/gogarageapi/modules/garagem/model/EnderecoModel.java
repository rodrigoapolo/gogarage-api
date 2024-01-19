package com.gogarage.gogarageapi.modules.garagem.model;

import jakarta.persistence.Embeddable;
import lombok.Data;


import java.io.Serializable;

@Data
@Embeddable
public class EnderecoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String logradouro;
    private String cep;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String numero;

    public EnderecoModel() {
    }

    public EnderecoModel(String logradouro, String cep, String complemento, String bairro, String cidade, String uf, String numero) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;
    }
}
