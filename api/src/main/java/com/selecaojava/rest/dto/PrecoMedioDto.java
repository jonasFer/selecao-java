package com.selecaojava.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrecoMedioDto {

    @JsonProperty("preco_medio_venda")
    private float precoMedioVenda;

    @JsonProperty("preco_medio_compra")
    private float precoMedioCompra;

    public PrecoMedioDto(float precoMedioVenda, float precoMedioCompra) {
        this.precoMedioVenda = precoMedioVenda;
        this.precoMedioCompra = precoMedioCompra;
    }

    public float getPrecoMedioVenda() {
        return precoMedioVenda;
    }

    public float getPrecoMedioCompra() {
        return precoMedioCompra;
    }
}
