package com.selecaojava.rest.controller.estatistica;

import com.selecaojava.rest.dto.HistoricoDto;
import com.selecaojava.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("dados/data")
public class DadosPorDataController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/{data}")
    @ResponseStatus(HttpStatus.OK)
    public List<HistoricoDto> action(@PathVariable String data) throws ParseException {
        return historicoService.allByData(data);
    }
}
