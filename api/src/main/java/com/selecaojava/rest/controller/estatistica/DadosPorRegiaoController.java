package com.selecaojava.rest.controller.estatistica;

import com.selecaojava.rest.dto.HistoricoDto;
import com.selecaojava.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("dados/regiao")
public class DadosPorRegiaoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/{sigla}")
    @ResponseStatus(HttpStatus.OK)
    public List<HistoricoDto> action(@PathVariable String sigla) {
        return this.historicoService.dadosRegiaoPorSigla(sigla);
    }
}
