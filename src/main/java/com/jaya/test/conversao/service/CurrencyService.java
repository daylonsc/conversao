package com.jaya.test.conversao.service;

import com.jaya.test.conversao.client.ForeignExchangeRatesClient;
import com.jaya.test.conversao.controller.request.CurrencyRequest;
import com.jaya.test.conversao.controller.response.CurrencyResponse;
import com.jaya.test.conversao.controller.response.RateResponse;
import com.jaya.test.conversao.domain.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final ForeignExchangeRatesClient ratesClient;
    private final TransactionService transactionService;

    public CurrencyResponse convert(CurrencyRequest request){
        CurrencyResponse currencyResponse = build(request, getRate(request));
        Transaction transaction = transactionService.save(currencyResponse);
        currencyResponse.setTransactionId(transaction.getId());
        return currencyResponse;
    }

    private RateResponse getRate(CurrencyRequest request) {
        return ratesClient.getRate(List.of(request.getCurrencyFrom(), request.getCurrencyTo()), request.getCurrencyFrom());
    }

    private CurrencyResponse build(CurrencyRequest request, RateResponse rateResponse){
        return CurrencyResponse.builder()
                .currencyFrom(request.getCurrencyFrom())
                .currencyTo(request.getCurrencyTo())
                .rate(getRateByCurrency(request, rateResponse))
                .userId(1L)
                .valueFrom(request.getValue())
                .valueTo(convertValueByRate(request, rateResponse))
                .dateTimeUtc(LocalDateTime.now())
                .build();
    }

    private BigDecimal convertValueByRate(CurrencyRequest request, RateResponse rateResponse) {
        return getRateByCurrency(request, rateResponse).multiply(request.getValue());
    }

    private BigDecimal getRateByCurrency(CurrencyRequest request, RateResponse rateResponse) {
        return BigDecimal.valueOf((Double) ((LinkedHashMap) rateResponse.getRates()).get(request.getCurrencyTo()));
    }
}
