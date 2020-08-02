package com.selecaojava.service.impl;

import com.selecaojava.domain.entity.*;
import com.selecaojava.domain.repository.HistoricoRepository;
import com.selecaojava.exception.RegisterNotFoundException;
import com.selecaojava.rest.dto.HistoricoDto;
import com.selecaojava.rest.dto.PrecoMedioDto;
import com.selecaojava.service.*;
import com.selecaojava.util.Csv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricoServiceImpl implements HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;
    @Autowired
    private BandeiraService bandeiraService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private RevendaService revendaService;
    @Autowired
    private RegiaoService regiaoService;
    @Autowired
    private MunicipioService municipioService;

    @Override
    public HistoricoDto byId(Long id) {
        return historicoRepository
                .findById(id)
                .map( historico -> converterToDto(historico))
                .orElseThrow( () -> new RegisterNotFoundException("Histórico não encontrado"));
    }

    @Override
    public List<HistoricoDto> findAll() {
        return historicoRepository
                .findAll()
                .stream()
                .map( historico -> converterToDto(historico) )
                .collect(Collectors.toList());
    }

    @Override
    public HistoricoDto update(Long id, HistoricoDto historicoDto) throws ParseException  {
        return historicoRepository
                .findById(id)
                .map(historicoBanco ->  {
                    try {
                        float valorVenda = parseFloat(historicoDto.getValorVenda());
                        float valorCusto = parseFloat(historicoDto.getValorCusto());
                        historicoBanco.setRevenda(revendaService.byId(historicoDto.getRevenda()));
                        historicoBanco.setBandeira(bandeiraService.byId(historicoDto.getBandeira()));
                        historicoBanco.setProduto(produtoService.byId(historicoDto.getProduto()));
                        historicoBanco.setValorCompra(valorCusto);
                        historicoBanco.setValorVenda(valorVenda);
                        historicoBanco.setUnidade(historicoDto.getUnidade());
                        historicoBanco
                                .setData((new SimpleDateFormat("dd/MM/yyyy"))
                                .parse(historicoDto.getDataColeta()));

                        historicoRepository.save(historicoBanco);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    return converterToDto(historicoBanco);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST) );
    }

    @Override
    public HistoricoDto save(HistoricoDto historicoDto) throws ParseException {
        Historico historico = new Historico();

        historico.setRevenda(revendaService.byId(historicoDto.getRevenda()));
        historico.setBandeira(bandeiraService.byId(historicoDto.getBandeira()));
        historico.setProduto(produtoService.byId(historicoDto.getProduto()));
        historico.setValorCompra(parseFloat(historicoDto.getValorCusto()));
        historico.setValorVenda(parseFloat(historicoDto.getValorVenda()));
        historico.setUnidade(historicoDto.getUnidade());
        historico.setData((new SimpleDateFormat("dd/MM/yyyy")).parse(historicoDto.getDataColeta()));

        historicoRepository.save(historico);

        return converterToDto(historico);
    }

    @Override
    public void delete(Long id) {
        historicoRepository
                .findById(id)
                .map( historico -> {
                    historicoRepository.delete(historico);
                    return Void.TYPE;
                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void saveFromCsv(List<String[]> dados) throws ParseException {
        for (String[] dado : dados) {
            if (dado.length == Csv.QTD_CAMPOS) {
                String nome = dado[Csv.PRODUTO];
                String revendaNome = dado[Csv.REVENDEDA];
                float valorVenda = parseFloat(dado[Csv.VALOR_VENDA]);
                float valorCompra = parseFloat(dado[Csv.VALOR_COMPRA]);
                String unidade = dado[Csv.UNIDADE];
                String bandeiraNome = dado[Csv.BANDEIRA];

                Bandeira bandeira = bandeiraService.findBandeiraByNome(bandeiraNome);
                Produto produto = produtoService.findProdutoByNome(nome);
                Revenda revenda = revendaService.findRevendaByNome(revendaNome);
                Date data = (new SimpleDateFormat("dd/MM/yyyy")).parse(dado[Csv.DATA]);

                Historico historico = new Historico(revenda, valorCompra, valorVenda, unidade, data, produto, bandeira);
                historicoRepository.save(historico);
            }
        }
    }

    private float parseFloat(String valor) throws ParseException {
        if (valor.isEmpty()) {
            return 0;
        }

        DecimalFormat format = new DecimalFormat("#.#");
        return format.parse(valor).floatValue();
    }

    @Override
    public PrecoMedioDto mediaValorPorMunicipio(String nomeMunicipio) {
        List<Revenda> revendas = revendaService.findAllByMunicipio(nomeMunicipio);
        return new PrecoMedioDto(
                historicoRepository.mediaValorVendaFromRevenda(revendas),
                historicoRepository.mediaValorCompraFromRevenda(revendas)
        );
    }

    @Override
    public PrecoMedioDto mediaValorPorBandeira(String nomeBandeira) {
        Bandeira bandeira = bandeiraService.findBandeiraByNome(nomeBandeira);

        return new PrecoMedioDto(
                historicoRepository.mediaValorVendaFromBandeira(bandeira),
                historicoRepository.mediaValorCompraFromBandeira(bandeira)
        );
    }

    @Override
    public List<HistoricoDto> dadosRegiaoPorSigla(String sigla) {
        Regiao regiao = regiaoService.findRegiaoByNome(sigla);
        return historicoRepository
                .findHistoricoByRegiao(regiao.getNome())
                .stream()
                .map(historico -> converterToDto(historico))
                .collect(Collectors.toList());
    }

    @Override
    public float mediaValorCustoPorMunicipio(String nome) {
        Municipio municipio = municipioService.findMunicipioByNome(nome);
        return historicoRepository.mediaValorCompraFromMunicipio(municipio.getId());
    }

    @Override
    public List<HistoricoDto> allByData(String data) throws ParseException {
        return historicoRepository
                .findHistoricoByData(new SimpleDateFormat("yyyy-MM-dd").parse(data))
                .stream()
                .map(historico -> converterToDto(historico))
                .collect(Collectors.toList());
    }

    @Override
    public List<HistoricoDto> allByRevenda(Long id) {
        Revenda revenda = revendaService.byId(id);
        return historicoRepository
                .findHistoricoByRevenda(revenda)
                .stream()
                .map(historico -> converterToDto(historico))
                .collect(Collectors.toList());
    }

    private HistoricoDto converterToDto(Historico historico) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        return new HistoricoDto(
                historico.getId(),
                historico.getRevenda().getId(),
                historico.getRevenda().getNome(),
                historico.getProduto().getId(),
                historico.getProduto().getNome(),
                dateFormat.format(historico.getData()),
                decimalFormat.format(historico.getValorVenda()),
                decimalFormat.format(historico.getValorCompra()),
                historico.getUnidade(),
                historico.getBandeira().getId()
        );
    }
}
