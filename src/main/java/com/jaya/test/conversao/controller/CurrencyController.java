package com.jaya.test.conversao.controller;

import com.jaya.test.conversao.controller.request.CurrencyRequest;
import com.jaya.test.conversao.controller.response.CurrencyResponse;
import com.jaya.test.conversao.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService service;

    @ResponseStatus(OK)
    @PostMapping
    public CurrencyResponse convert(@Valid @RequestBody CurrencyRequest request) {
        return service.convert(request);
    }
}
