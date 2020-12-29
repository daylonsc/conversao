package com.jaya.test.conversao.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal valueFrom;
    private BigDecimal rate;
    private LocalDateTime dateTimeUtc;

    public Transaction() {
    }

    public Transaction(Long id, User user, String currencyFrom, String currencyTo, BigDecimal valueFrom, BigDecimal rate, LocalDateTime dateTimeUtc) {
        this.id = id;
        this.user = user;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.valueFrom = valueFrom;
        this.rate = rate;
        this.dateTimeUtc = dateTimeUtc;
    }
}
