package com.selecaojava.service;

import com.selecaojava.domain.entity.Estado;

import java.util.List;

public interface EstadoService {

    public void saveFromCsv(List<String[]> dados);

    public Estado findEstadoBySigla(String sigla);
}
