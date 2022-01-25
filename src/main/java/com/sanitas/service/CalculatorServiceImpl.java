package com.sanitas.service;

import org.springframework.stereotype.Service;
import io.corp.calculator.TracerImpl;
import java.math.BigDecimal;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    private TracerImpl tracer;
    public CalculatorServiceImpl(TracerImpl tracer){
        this.tracer=tracer;
    }
    @Override
    public BigDecimal add(BigDecimal firstNumber, BigDecimal secondNumber) {
        tracer.trace("Calling add service with "+ firstNumber.toString()+" and "+ secondNumber.toString()+ " numbers");
        BigDecimal res = firstNumber.add(secondNumber);
        tracer.trace("Result "+ res);
        return res;
    }
    @Override
    public BigDecimal subtract(BigDecimal firstNumber, BigDecimal secondNumber) {
        tracer.trace("Calling subtract service with "+ firstNumber.toString()+" and "+ secondNumber.toString()+ " numbers");
        BigDecimal res = firstNumber.subtract(secondNumber);
        tracer.trace("Result "+ res);
        return res;
    }
}
