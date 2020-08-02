package com.selecaojava.rest.controller.estatistica;

import com.selecaojava.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("media/valor-custo/municipio")
public class MediaValorCustoPorMunicipioController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/{nome}")
    public ResponseEntity<Map<String, Float>> action(@PathVariable String nome) {
        Map<String, Float> response = new HashMap<>();
        response.put("media", historicoService.mediaValorCustoPorMunicipio(nome));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
