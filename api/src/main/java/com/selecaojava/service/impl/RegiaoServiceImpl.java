package com.selecaojava.service.impl;

import com.selecaojava.domain.entity.Regiao;
import com.selecaojava.domain.repository.RegiaoRepository;
import com.selecaojava.exception.RegisterNotFoundException;
import com.selecaojava.service.RegiaoService;
import com.selecaojava.util.Csv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RegiaoServiceImpl implements RegiaoService {

    @Autowired
    private RegiaoRepository regiaoRepository;
    HashMap<String, Regiao> regioes = new HashMap<String, Regiao>();

    public void saveFromCsv(List<String[]> dados) {
        for (String[] dado : dados) {
            if (dado.length == Csv.QTD_CAMPOS) {
                String nome = dado[Csv.REGIAO];
                if (!regioes.containsKey(nome)) {
                    Regiao regiao = new Regiao(nome);
                    regiaoRepository.save(regiao);
                    regioes.put(nome, regiao);
                }
            }
        }
    }

    @Override
    public Regiao findRegiaoByNome(String nome) {
        return regiaoRepository
                .findRegiaoByNome(nome)
                .orElseThrow(() -> new RegisterNotFoundException("Região não encontrada"));
    }
}
