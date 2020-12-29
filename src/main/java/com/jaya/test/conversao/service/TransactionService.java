package com.jaya.test.conversao.service;

import com.jaya.test.conversao.controller.response.CurrencyResponse;
import com.jaya.test.conversao.domain.Transaction;
import com.jaya.test.conversao.domain.User;
import com.jaya.test.conversao.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;

    @Transactional
    public Transaction save(CurrencyResponse currency) {
        return repository.save(build(currency));
    }

    private Transaction build(CurrencyResponse currency) {
        return Transaction.builder()
                .currencyFrom(currency.getCurrencyFrom())
                .currencyTo(currency.getCurrencyTo())
                .dateTimeUtc(currency.getDateTimeUtc())
                .rate(currency.getRate())
                .user(new User())
                .valueFrom(currency.getValueFrom())
                .build();
    }
}
