package com.gogarage.gogarageapi.modules.garagem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gogarage.gogarageapi.modules.garagem.SituacaoEnum;
import com.gogarage.gogarageapi.modules.agendamento.AgendamentoModel;
import com.gogarage.gogarageapi.modules.pessoa.PessoaModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "tb_garagem")
public class GaragemModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean cobertura;
    private String foto;
    private String horarioInicio;
    private String horarioTermino;
    private Double taxaHorario;
    private Double valorHora;
    private Double alturaVaga;
    private Double larguraVaga;
    private Boolean disponibilidade;
    private Boolean status;
    private Integer situacao;
    private String latitude;
    private String longitude;
    private EnderecoModel enderecoModel;
    @JsonIgnore()
    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL)
    private Set<AgendamentoModel> agendamentos = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaModel pessoa;
    public GaragemModel() {}
    public GaragemModel(Long id, Boolean cobertura, String foto, String horarioInicio, String horarioTermino,
                        Double taxaHorario, Double valorHora, Double alturaVaga, Double larguraVaga,
                        Boolean disponibilidade, Boolean status, SituacaoEnum situacaoEnum, String latitude, String longitude, PessoaModel pessoa) {
        this.id = id;
        this.cobertura = cobertura;
        this.foto = foto;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.taxaHorario = taxaHorario;
        this.valorHora = valorHora;
        this.alturaVaga = alturaVaga;
        this.larguraVaga = larguraVaga;
        this.disponibilidade = disponibilidade;
        this.status = status;
        setSituacao(situacaoEnum);
        this.latitude = latitude;
        this.longitude = longitude;
        this.pessoa = pessoa;
    }

    public void setSituacao(SituacaoEnum situacaoEnum) {
        if(situacaoEnum != null){
            this.situacao = situacaoEnum.getCod();
        }
    }

    public SituacaoEnum getSituacao() {
        return SituacaoEnum.valueOf(situacao);
    }



}
