package com.jaya.test.conversao.controller.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CurrencyRequest implements Serializable {
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal value;
}
