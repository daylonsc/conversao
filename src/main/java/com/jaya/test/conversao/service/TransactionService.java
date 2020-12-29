package com.jaya.test.conversao.service;

import com.jaya.test.conversao.client.ForeignExchangeRatesClient;
import com.jaya.test.conversao.controller.request.ConversionRequest;
import com.jaya.test.conversao.controller.response.RateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final ForeignExchangeRatesClient foreignExchangeRatesAPI;

    public RateResponse convert(ConversionRequest request){
        return foreignExchangeRatesAPI.getRate(List.of(request.getCurrencyFrom(), request.getCurrencyTo()), request.getCurrencyFrom());
    }
}
