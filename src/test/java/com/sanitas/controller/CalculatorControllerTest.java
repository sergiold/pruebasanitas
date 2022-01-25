package com.sanitas.controller;

import com.sanitas.exception.InvalidArgumentsException;
import com.sanitas.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;


    @Test
    public void addNumbersShouldOK() throws Exception{

        when(calculatorService.add(any(),any())).thenReturn(BigDecimal.ONE);

        mockMvc.perform(get("/calculator/add?firstNumber=10&secondNumber=-13")).andExpect(status().isOk());
    }

    @Test
    public void addNumbersShouldThrowException() throws Exception{

        when(calculatorService.add(any(),any())).thenReturn(BigDecimal.ONE);

        mockMvc.perform(get("/calculator/add?firstNumber=10&secondNumber=AAA")).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidArgumentsException));
    }

    @Test
    public void substractNumbersShouldOK() throws Exception{

        when(calculatorService.subtract(any(),any())).thenReturn(BigDecimal.ONE);

        mockMvc.perform(get("/calculator/add?firstNumber=10&secondNumber=-13")).andExpect(status().isOk());
    }

    @Test
    public void substractNumbersShouldThrowException() throws Exception{

        when(calculatorService.subtract(any(),any())).thenReturn(BigDecimal.ONE);

        mockMvc.perform(get("/calculator/subtract?firstNumber=10&secondNumber=AAA")).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidArgumentsException));
    }
}
