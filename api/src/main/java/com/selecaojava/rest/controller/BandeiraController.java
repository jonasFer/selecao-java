package com.selecaojava.rest.controller;

import com.selecaojava.domain.entity.Bandeira;
import com.selecaojava.service.BandeiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bandeira")
public class BandeiraController {

    @Autowired
    private BandeiraService bandeiraService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Bandeira> all() {
        return bandeiraService.findAll();
    }
}
