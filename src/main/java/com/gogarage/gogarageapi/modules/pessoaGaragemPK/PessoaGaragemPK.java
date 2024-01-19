package com.gogarage.gogarageapi.modules.pessoaGaragemPK;

import com.gogarage.gogarageapi.modules.garagem.model.GaragemModel;
import com.gogarage.gogarageapi.modules.pessoa.PessoaModel;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class PessoaGaragemPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private PessoaModel pessoa;
    @ManyToOne
    @JoinColumn(name = "idGaragem")
    private GaragemModel garagem;
}
