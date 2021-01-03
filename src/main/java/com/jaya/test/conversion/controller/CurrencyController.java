package com.jaya.test.conversion.controller;

import com.jaya.test.conversion.controller.request.CurrencyRequest;
import com.jaya.test.conversion.controller.response.CurrencyResponse;
import com.jaya.test.conversion.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService service;

    @ResponseStatus(OK)
    @PostMapping
    public CurrencyResponse convert(@Valid @RequestBody CurrencyRequest request, HttpServletRequest httpRequest) {
        return service.convert(request, httpRequest);
    }
}
