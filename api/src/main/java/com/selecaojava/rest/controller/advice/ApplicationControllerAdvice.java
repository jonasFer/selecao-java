package com.selecaojava.rest.controller.advice;

import com.selecaojava.exception.RegisterNotFoundException;
import com.selecaojava.rest.controller.ApiErrors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegisterNotFoundException.class)
    public ApiErrors handleRegisterNotFoundException(RegisterNotFoundException ex) {
        return new ApiErrors(ex.getMessage());
    }
}
