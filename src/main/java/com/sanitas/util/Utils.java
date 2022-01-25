package com.sanitas.util;

import java.math.BigDecimal;


public class Utils {

    public static BigDecimal convert(String number){
        return BigDecimal.valueOf(Double.parseDouble(number));
    }
}
