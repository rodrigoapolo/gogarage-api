package com.gogarage.gogarageapi.modules.garagem;

public enum SituacaoEnum {


    AGUARDANDO_AVALIACAO(1),
    SENDO_AVALIADO(2),
    REPROVADO(3),
    APROVADO(4),
    CANCELADO(5),
    REVISAO(6);

    private int code;

    private SituacaoEnum(int code) {
        this.code = code;
    }

    public int getCod(){
        return code;
    }

    public static SituacaoEnum valueOf(int code){
        for(SituacaoEnum value : SituacaoEnum.values()){
            if(value.getCod() == code){
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid OrederStatus code!");
    }
}
