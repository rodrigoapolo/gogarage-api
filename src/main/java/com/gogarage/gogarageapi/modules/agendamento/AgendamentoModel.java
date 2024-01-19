package com.gogarage.gogarageapi.modules.agendamento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gogarage.gogarageapi.modules.garagem.model.GaragemModel;
import com.gogarage.gogarageapi.modules.pessoa.PessoaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="tb_Agendamento")
public class AgendamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @JsonIgnore()
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pessoa_id")
    private PessoaModel pessoa;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "garage_id")
    private GaragemModel garage;
    private String data_inicio;
    private String data_final;

}
