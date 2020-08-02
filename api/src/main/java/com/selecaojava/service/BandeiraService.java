package com.selecaojava.service;

import com.selecaojava.domain.entity.Bandeira;

import java.util.List;

public interface BandeiraService {

    public void saveFromCsv(List<String[]> dados);

    public Bandeira byId(Long id);

    public Bandeira findBandeiraByNome(String nome);
}
