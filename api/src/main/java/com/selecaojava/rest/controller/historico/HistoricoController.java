package com.selecaojava.rest.controller.historico;

import com.selecaojava.rest.dto.HistoricoDto;
import com.selecaojava.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HistoricoDto byId(@PathVariable Long id) {
        return historicoService.byId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HistoricoDto> all() {
        return historicoService.findAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public HistoricoDto update(@PathVariable Long id, @RequestBody HistoricoDto historicoDto) throws ParseException {
        return historicoService.update(id, historicoDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HistoricoDto save(@RequestBody HistoricoDto historicoDto) throws ParseException {
        return historicoService.save(historicoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.historicoService.delete(id);
    }
}
