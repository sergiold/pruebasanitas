package com.sanitas.config;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfig {

    @Bean
    public TracerImpl getTrace(){
        return new TracerImpl();
    }

}
