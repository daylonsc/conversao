package com.jaya.test.conversao.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaya.test.conversao.controller.response.CurrencyResponse;
import com.jaya.test.conversao.controller.response.TransactionUserResponse;
import com.jaya.test.conversao.domain.Transaction;
import com.jaya.test.conversao.domain.User;
import com.jaya.test.conversao.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;
    private ObjectMapper mapper = new ObjectMapper();

    @Transactional
    public Transaction save(CurrencyResponse currency) {
        return repository.save(build(currency));
    }

    public List<TransactionUserResponse> getTransactions(){
        return repository.findAllByUserId(1L);
    }

    private Transaction build(CurrencyResponse currency) {
        return Transaction.builder()
                .currencyFrom(currency.getCurrencyFrom())
                .currencyTo(currency.getCurrencyTo())
                .dateTimeUtc(currency.getDateTimeUtc())
                .rate(currency.getRate())
                .user(new User(1L))
                .valueFrom(currency.getValueFrom())
                .build();
    }
}
