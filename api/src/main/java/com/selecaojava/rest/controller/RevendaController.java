package com.selecaojava.rest.controller;

import com.selecaojava.domain.entity.Revenda;
import com.selecaojava.service.RevendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/revenda")
public class RevendaController {

    @Autowired
    private RevendaService revendaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Revenda> all() {
        return revendaService.findAll();
    }
}
