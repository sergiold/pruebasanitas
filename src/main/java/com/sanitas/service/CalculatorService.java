package com.sanitas.service;

import java.math.BigDecimal;

public interface CalculatorService {
    BigDecimal add(BigDecimal firstNumber,BigDecimal secondNumber);
    BigDecimal subtract(BigDecimal firstNumber,BigDecimal secondNumber);
}
