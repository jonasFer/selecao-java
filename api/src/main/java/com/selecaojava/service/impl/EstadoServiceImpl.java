package com.selecaojava.service.impl;

import com.selecaojava.domain.entity.Estado;
import com.selecaojava.domain.entity.Regiao;
import com.selecaojava.domain.repository.EstadoRepository;
import com.selecaojava.service.EstadoService;
import com.selecaojava.service.RegiaoService;
import com.selecaojava.util.Csv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private RegiaoService regiaoService;
    HashMap<String, Estado> estadoHashMap = new HashMap<String, Estado>();

    public void saveFromCsv(List<String[]> dados) {
        for (String[] dado : dados) {
            if (dado.length == Csv.QTD_CAMPOS) {
                String sigla = dado[Csv.ESTADO];

                if (!estadoHashMap.containsKey(sigla)) {
                    Regiao regiao = regiaoService.findRegiaoByNome(dado[Csv.REGIAO]);
                    Estado estado = new Estado(sigla, regiao);
                    estadoRepository.save(estado);
                    estadoHashMap.put(sigla, estado);
                }
            }
        }
    }

    @Override
    public Estado findEstadoBySigla(String sigla) {
        return estadoRepository.findEstadoBySigla(sigla);
    }
}
