package com.jaya.test.conversao.controller.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class RateResponse implements Serializable {
    private Object rates;
    private String base;
    private LocalDate date;
}
