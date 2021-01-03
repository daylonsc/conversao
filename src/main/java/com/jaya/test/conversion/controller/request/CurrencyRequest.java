package com.jaya.test.conversion.controller.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CurrencyRequest implements Serializable {
    @NotBlank(message = "Currency from is required")
    private String currencyFrom;
    @NotBlank(message = "Currency to is required")
    private String currencyTo;
    @NotNull(message = "Value from is required")
    private BigDecimal value;
}
