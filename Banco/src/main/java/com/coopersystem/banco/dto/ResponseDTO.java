package com.coopersystem.banco.dto;

public class ResponseDTO {
    CotacaoDTO[] value;

    public CotacaoDTO[] getValue() {
        return value;
    }

    public void setValue(CotacaoDTO[] value) {
        this.value = value;
    }
}
