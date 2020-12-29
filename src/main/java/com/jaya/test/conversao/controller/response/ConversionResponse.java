package com.jaya.test.conversao.controller.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ConversionResponse implements Serializable {
    private Long transactionId;
    private Long userId;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal valueFrom;
    private BigDecimal valueTo;
    private String rate;
    private LocalDateTime dateTimeUtc;
}
