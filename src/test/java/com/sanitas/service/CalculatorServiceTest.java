package com.sanitas.service;

import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;


@SpringBootTest
public class CalculatorServiceTest {

    @Mock
    private TracerImpl tracer;
    @InjectMocks
    private CalculatorServiceImpl calculatorService;
    @Test
    public void addNumbersOK(){

       BigDecimal res = calculatorService.add(BigDecimal.valueOf(10),BigDecimal.valueOf(15));
       assertEquals(BigDecimal.valueOf(25),res);
       verify(tracer,times(2)).trace(any());

    }

    @Test
    public void subtractNumbersOK(){
        BigDecimal res = calculatorService.subtract(BigDecimal.valueOf(10),BigDecimal.valueOf(15));
        assertEquals(BigDecimal.valueOf(-5),res);
        verify(tracer,times(2)).trace(any());
    }
}
