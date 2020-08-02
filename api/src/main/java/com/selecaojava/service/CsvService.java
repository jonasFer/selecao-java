package com.selecaojava.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CsvService {
    public void upload(MultipartFile csv) throws Exception;
}
