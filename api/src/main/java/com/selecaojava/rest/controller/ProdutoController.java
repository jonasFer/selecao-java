package com.selecaojava.rest.controller;

import com.selecaojava.domain.entity.Produto;
import com.selecaojava.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> all() {
        return service.findAll();
    }
}
