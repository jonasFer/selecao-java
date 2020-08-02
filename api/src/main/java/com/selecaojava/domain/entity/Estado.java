package com.selecaojava.domain.entity;

import javax.persistence.*;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sigla;
    @ManyToOne
    private Regiao regiao;

    public Estado() {}

    public Estado(String sigla, Regiao regiao) {
        this.sigla = sigla;
        this.regiao = regiao;
    }

    public Long getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }

    public Regiao getRegiao() {
        return regiao;
    }
}
