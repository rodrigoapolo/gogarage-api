package com.gogarage.gogarageapi.modules.agendamento.dtos;

import lombok.Data;

@Data
public class AgendamentoDTO {
    private Long idPessoa;
    private Long idGaragem;
    private String data_inicio;
    private String data_final;
}
