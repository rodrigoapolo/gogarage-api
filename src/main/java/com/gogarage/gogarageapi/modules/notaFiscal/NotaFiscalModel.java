package com.gogarage.gogarageapi.modules.notaFiscal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_NotaFiscal")
public class NotaFiscalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double total;
    
    private Double taxa;

    private String data;

    private String hora_vaga;

    public NotaFiscalModel() {
    }

    public NotaFiscalModel(Long id, Double total, Double taxa, String data, String hora_vaga) {
        this.id = id;
        this.total = total;
        this.taxa = taxa;
        this.data = data;
        this.hora_vaga = hora_vaga;
    }
}
