package com.gogarage.gogarageapi.modules.garagem.dtos;

import com.gogarage.gogarageapi.modules.garagem.model.EnderecoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GaragemDTO {
    private Long id;
    private Boolean cobertura;
    @NotBlank
    private String horarioInicio;
    @NotBlank
    private String horarioTermino;
    @NotNull
    private Double taxaHorario;
    private Double valorHora;
    @NotNull
    private Double alturaVaga;
    @NotNull
    private Double larguraVaga;
    private String latitude;
    private String longitude;
    @NotNull
    private Long idPssoa;
    private EnderecoModel endereco;
}
