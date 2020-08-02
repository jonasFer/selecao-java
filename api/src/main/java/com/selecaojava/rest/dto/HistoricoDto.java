package com.selecaojava.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoricoDto {

    private Long id;
    private Long revenda;
    @JsonProperty("revenda_nome")
    private String nomeRevenda;
    private Long produto;
    @JsonProperty("produto_nome")
    private String nomeProduto;
    @JsonProperty("data_coleta")
    private String dataColeta;
    @JsonProperty("valor_venda")
    private String valorVenda;
    @JsonProperty("valor_custo")
    private String valorCusto;
    private String  unidade;
    private Long bandeira;

    public HistoricoDto(
        Long id,
        Long revenda,
        String revendaNome,
        Long produto,
        String produtoNome,
        String dataColeta,
        String valorVenda,
        String valorCusto,
        String  unidade,
        Long bandeira
    ) {
        this.id = id;
        this.revenda = revenda;
        this.nomeRevenda = revendaNome;
        this.produto = produto;
        this.nomeProduto = produtoNome;
        this.dataColeta = dataColeta;
        this.valorVenda = valorVenda;
        this.valorCusto = valorCusto;
        this.unidade = unidade;
        this.bandeira = bandeira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(String valorCusto) {
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

    public void setRevenda(Long revenda) {
        this.revenda = revenda;
    }

    public String getNomeRevenda() {
        return nomeRevenda;
    }

    public void setNomeRevenda(String nomeRevenda) {
        this.nomeRevenda = nomeRevenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}
