package com.selecaojava.rest.controller.estatistica;

import com.selecaojava.rest.dto.PrecoMedioDto;
import com.selecaojava.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/media")
public class MediaValorPorMunicipioController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/municipio/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public PrecoMedioDto action(@PathVariable String nome) {
        return this.historicoService.mediaValorPorMunicipio(nome);
    }
}
