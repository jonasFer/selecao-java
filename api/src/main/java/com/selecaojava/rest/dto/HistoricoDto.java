package com.selecaojava.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoricoDto {

    private Long revenda;
    private Long produto;
    @JsonProperty("data_coleta")
    private String dataColeta;
    @JsonProperty("valor_venda")
    private float valorVenda;
    @JsonProperty("valor_custo")
    private float valorCusto;
    private String  unidade;
    private Long bandeira;

    public HistoricoDto(
        Long revenda,
        Long produto,
        String dataColeta,
        float valorVenda,
        float valorCusto,
        String  unidade,
        Long bandeira
    ) {
        this.revenda = revenda;
        this.produto = produto;
        this.dataColeta = dataColeta;
        this.valorVenda = valorVenda;
        this.valorCusto = valorCusto;
        this.unidade = unidade;
        this.bandeira = bandeira;
    }

    public Long getRevenda() {
        return revenda;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

    public String getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(String dataColeta) {
        this.dataColeta = dataColeta;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public float getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(float valorCusto) {
        this.valorCusto = valorCusto;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Long getBandeira() {
        return bandeira;
    }

    public void setBandeira(Long bandeira) {
        this.bandeira = bandeira;
    }
}
