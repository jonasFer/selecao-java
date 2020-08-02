package com.selecaojava.service;

import com.selecaojava.rest.dto.HistoricoDto;
import com.selecaojava.rest.dto.PrecoMedioDto;

import java.text.ParseException;
import java.util.List;

public interface HistoricoService {

    public HistoricoDto byId(Long id);

    public List<HistoricoDto> findAll();

    public HistoricoDto update(Long id, HistoricoDto historicoDto) throws ParseException;

    public HistoricoDto save(HistoricoDto historicoDto) throws ParseException;

    public void delete(Long id);

    public void saveFromCsv(List<String[]> dados) throws ParseException;

    public PrecoMedioDto mediaValorPorMunicipio(String nomeMunicipio);

    public PrecoMedioDto mediaValorPorBandeira(String nomeBandeira);

    public List<HistoricoDto> dadosRegiaoPorSigla(String sigla);

    public float mediaValorCustoPorMunicipio(String nome);

    public List<HistoricoDto> allByData(String data) throws ParseException;

    public List<HistoricoDto> allByRevenda(Long id);
}
