package com.sanitas.controller;

import com.sanitas.service.CalculatorService;
import com.sanitas.util.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public ResponseEntity<String> addNumbers(@RequestParam String firstNumber, @RequestParam String secondNumber){

        BigDecimal result = calculatorService.add(Utils.convert(firstNumber),Utils.convert(secondNumber));
        return new ResponseEntity<>(result.toString(), HttpStatus.OK);
    }
}
