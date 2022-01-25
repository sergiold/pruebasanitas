package com.sanitas.util;

import java.math.BigDecimal;
import java.util.Optional;
import org.apache.commons.lang3.math.NumberUtils;

public class Utils {

    public static Optional<BigDecimal> convert(String number) {
        if (NumberUtils.isCreatable(number)) {
            return Optional.of(BigDecimal.valueOf(Double.parseDouble(number)));
        } else {
            return Optional.empty();
        }
    }

}
