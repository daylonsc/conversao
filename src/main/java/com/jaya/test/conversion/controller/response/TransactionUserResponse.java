package com.jaya.test.conversion.controller.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TransactionUserResponse implements Serializable {
    private Long transactionId;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal valueFrom;
    private BigDecimal rate;
    private LocalDateTime dateTimeUtc;
}
