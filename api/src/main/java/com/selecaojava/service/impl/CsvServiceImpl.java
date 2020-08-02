package com.selecaojava.service.impl;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.selecaojava.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CsvServiceImpl implements CsvService {
    @Autowired
    private BandeiraService bandeiraService;

    @Autowired
    private RegiaoService regiaoService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private MunicipioService municipioService;

    @Autowired
    private RevendaService revendaService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private HistoricoService historicoService;

    @Override
    public void upload(MultipartFile csv) throws Exception {
        List<String[]> dadosCsv = readerCsv(csv);
        bandeiraService.saveFromCsv(dadosCsv);
        regiaoService.saveFromCsv(dadosCsv);
        estadoService.saveFromCsv(dadosCsv);
        municipioService.saveFromCsv(dadosCsv);
        revendaService.saveFromCsv(dadosCsv);
        regiaoService.saveFromCsv(dadosCsv);
        produtoService.saveFromCsv(dadosCsv);
        historicoService.saveFromCsv(dadosCsv);
    }

    private List<String[]> readerCsv(MultipartFile csv) throws IOException {
        CSVParserBuilder parserBuilder = new CSVParserBuilder();
        CSVParser csvParser = parserBuilder
                .withSeparator('\t')
                .withIgnoreQuotations(false)
                .build();

        CSVReaderBuilder csvReaderBuilder = new CSVReaderBuilder(new InputStreamReader(csv.getInputStream(), "UTF-16"));
        CSVReader csvReader = csvReaderBuilder.withCSVParser(csvParser).withSkipLines(1).build();
        return csvReader.readAll();
    }
}
