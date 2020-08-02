package com.selecaojava.rest.controller.estatistica;

import com.selecaojava.rest.dto.HistoricoDto;
import com.selecaojava.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("dados/revenda")
public class DadosPorRevendaController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<HistoricoDto> action(@PathVariable Long id) {
        return historicoService.allByRevenda(id);
    }
}
