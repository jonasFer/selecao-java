package com.selecaojava.rest.controller.csv;

import com.selecaojava.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("csv")
public class CsvController {

    @Autowired
    private CsvService csvService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadAction(@RequestPart MultipartFile arquivo) throws Exception {
        this.csvService.upload(arquivo);
    }
}
