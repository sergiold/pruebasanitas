package com.sanitas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CalculatorControllerAdvice {

    @ResponseBody
    @ExceptionHandler(InvalidArgumentsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String InvalidArgumentsHandler(InvalidArgumentsException ex) {
        return ex.getMessage();
    }
}
