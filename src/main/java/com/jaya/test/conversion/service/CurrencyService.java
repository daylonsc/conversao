package com.jaya.test.conversion.service;

import com.jaya.test.conversion.client.ForeignExchangeRatesClient;
import com.jaya.test.conversion.controller.request.CurrencyRequest;
import com.jaya.test.conversion.controller.response.CurrencyResponse;
import com.jaya.test.conversion.controller.response.RateResponse;
import com.jaya.test.conversion.domain.Transaction;
import com.jaya.test.conversion.exception.BadRequestException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final ForeignExchangeRatesClient ratesClient;
    private final TransactionService transactionService;

    public CurrencyResponse convert(CurrencyRequest request, HttpServletRequest httpRequest){
        validate(request);
        CurrencyResponse currencyResponse = build(request, getRate(request));
        Transaction transaction = transactionService.save(currencyResponse, httpRequest);
        currencyResponse.setTransactionId(transaction.getId());
        currencyResponse.setUserId(transaction.getUser().getId());
        return currencyResponse;
    }

    private void validate(CurrencyRequest request) {
        if (request.getValue().compareTo(BigDecimal.ZERO) != 1) {
            throw new BadRequestException("Value can not be less than Zero or equal to Zero.");
        }
    }

    private RateResponse getRate(CurrencyRequest request) {
        try{
            return ratesClient.getRate(List.of(request.getCurrencyFrom(), request.getCurrencyTo()), request.getCurrencyFrom());
        }catch (FeignException ex){
            throw new BadRequestException("exchangeratesapi is not available", ex);
        }
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
