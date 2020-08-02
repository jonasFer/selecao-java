package com.selecaojava.rest.controller.estatistica;

import com.selecaojava.rest.dto.PrecoMedioDto;
import com.selecaojava.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("media/bandeira")
public class MediaValorPorBandeiraController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public PrecoMedioDto action(@PathVariable String nome) {
        return historicoService.mediaValorPorBandeira(nome);
    }

}
