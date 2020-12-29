package com.jaya.test.conversao.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Transaction implements Serializable {

    @Id
    private Long id;
    private User user;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal valueTo;
    private BigDecimal valueFrom;
    private String rate;
    private LocalDateTime dateTimeUtc;
}
