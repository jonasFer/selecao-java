package com.selecaojava.service;

import com.selecaojava.domain.entity.Municipio;

import java.util.List;

public interface MunicipioService {

    public void saveFromCsv(List<String[]> dados);

    public Municipio findMunicipioByNome(String nome);
}
