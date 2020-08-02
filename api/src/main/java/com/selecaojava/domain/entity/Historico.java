package com.selecaojava.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "historico")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Revenda revenda;
    private float valorCompra;
    private float valorVenda;
    private String unidade;
    private Date data;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private Bandeira bandeira;

    public Historico() {}

    public Historico(
            Revenda revenda,
            float valorCompra,
            float valorVenda,
            String unidade,
            Date data,
            Produto produto,
            Bandeira bandeira
    ) {
        this.revenda = revenda;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.unidade = unidade;
        this.data = data;
        this.produto = produto;
        this.bandeira = bandeira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Revenda getRevenda() {
        return revenda;
    }

    public void setRevenda(Revenda revenda) {
        this.revenda = revenda;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }
}
