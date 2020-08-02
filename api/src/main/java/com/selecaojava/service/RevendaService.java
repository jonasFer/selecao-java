package com.selecaojava.service;

import com.selecaojava.domain.entity.Revenda;

import java.util.List;

public interface RevendaService {

    public void saveFromCsv(List<String[]> dados);

    public Revenda byId(Long id);

    public Revenda findRevendaByNome(String nome);

    public List<Revenda> findAllByMunicipio(String municipio);
}
