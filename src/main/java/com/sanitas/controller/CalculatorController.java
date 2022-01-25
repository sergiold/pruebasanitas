package com.sanitas.controller;

import com.sanitas.exception.InvalidArgumentsException;
import com.sanitas.service.CalculatorService;
import com.sanitas.util.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public ResponseEntity<String> addNumbers(@RequestParam String firstNumber, @RequestParam String secondNumber){

        Optional<BigDecimal> firstN = Utils.convert(firstNumber);
        Optional<BigDecimal> secondN = Utils.convert(secondNumber);
        if(firstN.isPresent() && secondN.isPresent()) {
            BigDecimal result = calculatorService.add(firstN.get(), secondN.get());
            return new ResponseEntity<>(result.toString(), HttpStatus.OK);
        }
        else {
            throw new InvalidArgumentsException(firstNumber+ " " + secondNumber);
        }
    }
    @GetMapping("/subtract")
    public ResponseEntity<String> subtractNumbers(@RequestParam String firstNumber, @RequestParam String secondNumber){

        Optional<BigDecimal> firstN = Utils.convert(firstNumber);
        Optional<BigDecimal> secondN = Utils.convert(secondNumber);
        if(firstN.isPresent() && secondN.isPresent()) {
            BigDecimal result = calculatorService.subtract(firstN.get(), secondN.get());
            return new ResponseEntity<>(result.toString(), HttpStatus.OK);
        }
        else {
            throw new InvalidArgumentsException(firstNumber+ " " + secondNumber);
        }
    }
}
