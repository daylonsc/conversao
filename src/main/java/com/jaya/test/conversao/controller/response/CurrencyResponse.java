package com.jaya.test.conversao.controller.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CurrencyResponse implements Serializable {
    private Long transactionId;
    private Long userId;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal valueFrom;
    private BigDecimal valueTo;
    private BigDecimal rate;
    private LocalDateTime dateTimeUtc;
}
