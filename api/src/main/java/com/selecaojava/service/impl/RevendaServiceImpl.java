package com.selecaojava.service.impl;

import com.selecaojava.domain.entity.Municipio;
import com.selecaojava.domain.entity.Revenda;
import com.selecaojava.domain.repository.RevendaRepository;
import com.selecaojava.exception.RegisterNotFoundException;
import com.selecaojava.service.MunicipioService;
import com.selecaojava.service.RevendaService;
import com.selecaojava.util.Csv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RevendaServiceImpl implements RevendaService {

    @Autowired
    private RevendaRepository revendaRepository;
    @Autowired
    private MunicipioService municipioService;
    HashMap<String, Revenda> revendaHashMap = new HashMap<String, Revenda>();

    public void saveFromCsv(List<String[]> dados) {
        for (String[] dado : dados) {
            if (dado.length == Csv.QTD_CAMPOS) {
                String nome = dado[Csv.REVENDEDA];
                String cnpj = dado[Csv.CNPJ];
                if (!revendaHashMap.containsKey(nome)) {
                    Municipio municipio = municipioService.findMunicipioByNome(dado[Csv.MUNICIPIO]);
                    Revenda revenda = new Revenda(cnpj, nome, municipio);
                    revendaRepository.save(revenda);
                    revendaHashMap.put(nome, revenda);
                }
            }
        }
    }

    @Override
    public Revenda byId(Long id) {
        return revendaRepository
                .findById(id)
                .orElseThrow(() -> new RegisterNotFoundException("Revenda não encontrada"));
    }

    @Override
    public Revenda findRevendaByNome(String nome) {
        return revendaRepository
                .findFirstRevendaByNome(nome)
                .orElseThrow(() -> new RegisterNotFoundException("Revenda não encontrada"));
    }

    @Override
    public List<Revenda> findAllByMunicipio(String nomeMunicipio) {
        Municipio municipio = municipioService.findMunicipioByNome(nomeMunicipio);

        return revendaRepository.findRevendaByMunicipio(municipio);
    }
}
