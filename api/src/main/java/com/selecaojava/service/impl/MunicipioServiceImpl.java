package com.selecaojava.service.impl;

import com.selecaojava.domain.entity.Estado;
import com.selecaojava.domain.entity.Municipio;
import com.selecaojava.domain.repository.MunicipioRepository;
import com.selecaojava.exception.RegisterNotFoundException;
import com.selecaojava.service.EstadoService;
import com.selecaojava.service.MunicipioService;
import com.selecaojava.util.Csv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MunicipioServiceImpl  implements MunicipioService {

    @Autowired
    MunicipioRepository municipioRepository;
    @Autowired
    EstadoService estadoService;

    public void saveFromCsv(List<String[]> dados) {
        HashMap<String, Municipio> municipioHashMap = new HashMap<String, Municipio>();
        for (String[] dado : dados) {
            if (dado.length == Csv.QTD_CAMPOS) {
                String nome = dado[Csv.MUNICIPIO];
                if (!municipioHashMap.containsKey(nome)) {
                    Estado estado = estadoService.findEstadoBySigla(dado[Csv.ESTADO]);
                    Municipio municipio = new Municipio(nome, estado);
                    municipioRepository.save(municipio);
                    municipioHashMap.put(nome, municipio);
                }
            }
        }
    }

    @Override
    public Municipio findMunicipioByNome(String nome) {
        return municipioRepository
                .findMunicipioByNome(nome)
                .orElseThrow(() -> new RegisterNotFoundException("Município não encontrado")
                );
    }
}
