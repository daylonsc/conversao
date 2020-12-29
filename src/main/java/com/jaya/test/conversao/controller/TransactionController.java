package com.jaya.test.conversao.controller;

import com.jaya.test.conversao.controller.request.ConversionRequest;
import com.jaya.test.conversao.controller.response.RateResponse;
import com.jaya.test.conversao.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @ResponseStatus(OK)
    @PostMapping
    public RateResponse convert(@Valid @RequestBody ConversionRequest request) {
        return service.convert(request);
    }
}
