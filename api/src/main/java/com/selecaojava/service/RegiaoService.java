package com.selecaojava.service;

import com.selecaojava.domain.entity.Regiao;

import java.util.List;

public interface RegiaoService {

    public void saveFromCsv(List<String[]> dados);

    public Regiao findRegiaoByNome(String nome);
}
