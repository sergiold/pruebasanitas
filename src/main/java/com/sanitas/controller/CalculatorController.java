package com.sanitas.controller;

import com.sanitas.exception.InvalidArgumentsException;
import com.sanitas.service.CalculatorService;
import com.sanitas.util.Utils;
import io.corp.calculator.TracerImpl;
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
    private TracerImpl tracer;


    public CalculatorController(CalculatorService calculatorService, TracerImpl tracer) {
        this.calculatorService = calculatorService;
        this.tracer = tracer;
    }


    @GetMapping("/add")
    public ResponseEntity<String> addNumbers(@RequestParam String firstNumber, @RequestParam String secondNumber) {

        tracer.trace("addNumbers called.");
        Optional<BigDecimal> firstN = Utils.convert(firstNumber);
        Optional<BigDecimal> secondN = Utils.convert(secondNumber);
        if (!firstN.isPresent() || !secondN.isPresent()) {
            tracer.trace("addNumbers threw exception");
            throw new InvalidArgumentsException(firstNumber + " " + secondNumber);
        }

        BigDecimal result = calculatorService.add(firstN.get(), secondN.get());
        tracer.trace("addNumbers OK Response");
        return new ResponseEntity<>(result.toString(), HttpStatus.OK);

    }

    @GetMapping("/subtract")
    public ResponseEntity<String> subtractNumbers(@RequestParam String firstNumber, @RequestParam String secondNumber) {

        tracer.trace("subtractNumbers called.");
        Optional<BigDecimal> firstN = Utils.convert(firstNumber);
        Optional<BigDecimal> secondN = Utils.convert(secondNumber);
        if (!firstN.isPresent() || !secondN.isPresent()) {
            tracer.trace("substractNumbers threw exception");
            throw new InvalidArgumentsException(firstNumber + " " + secondNumber);
        }
        BigDecimal result = calculatorService.subtract(firstN.get(), secondN.get());
        tracer.trace("substractNumbers OK Response");
        return new ResponseEntity<>(result.toString(), HttpStatus.OK);

    }
}
