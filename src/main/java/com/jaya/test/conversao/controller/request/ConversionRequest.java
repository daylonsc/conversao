package com.jaya.test.conversao.controller.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ConversionRequest implements Serializable {
    private Long userId;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal value;
}
