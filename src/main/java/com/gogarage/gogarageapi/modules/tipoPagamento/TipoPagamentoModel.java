package com.gogarage.gogarageapi.modules.tipoPagamento;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TipoPagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public TipoPagamentoModel() {
    }

    public TipoPagamentoModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
