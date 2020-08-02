package com.selecaojava.service.impl;

import com.selecaojava.domain.entity.Bandeira;
import com.selecaojava.domain.repository.BandeiraRepository;
import com.selecaojava.exception.RegisterNotFoundException;
import com.selecaojava.service.BandeiraService;
import com.selecaojava.util.Csv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BandeiraServiceImpl implements BandeiraService {

    @Autowired
    private BandeiraRepository bandeiraRepository;
    HashMap<String, Bandeira> bandeiras = new HashMap<String, Bandeira>();

    public void saveFromCsv(List<String[]> dados) {
        for (String[] dado : dados) {
            if (dado.length == Csv.QTD_CAMPOS) {
                String nome = dado[Csv.BANDEIRA];
                if (!bandeiras.containsKey(nome)) {
                    Bandeira bandeira = new Bandeira(nome);
                    bandeiraRepository.save(bandeira);
                    bandeiras.put(nome, bandeira);
                }
            }
        }
    }

    @Override
    public Bandeira byId(Long id) {
        return bandeiraRepository
                .findById(id)
                .orElseThrow(()
                                -> new RegisterNotFoundException("Bandeira não encontrada")
                );
    }

    @Override
    public Bandeira findBandeiraByNome(String nome) {
        return bandeiraRepository
                .findBandeiraByNome(nome)
                .orElseThrow(() ->
                        new RegisterNotFoundException("Bandeira não encontrada")
                );
    }
}
