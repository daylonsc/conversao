package com.jaya.test.conversion.service;

import com.jaya.test.conversion.controller.response.CurrencyResponse;
import com.jaya.test.conversion.controller.response.TransactionUserResponse;
import com.jaya.test.conversion.domain.Transaction;
import com.jaya.test.conversion.domain.UserMain;
import com.jaya.test.conversion.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;
    private final UserService userDetailsService;

    @Transactional
    public Transaction save(CurrencyResponse currency, HttpServletRequest request) {
        return repository.save(build(currency, request));
    }

    public List<TransactionUserResponse> getTransactions(HttpServletRequest request) {
        return repository.findAllByUserId(getUser(request).getId());
    }

    private Transaction build(CurrencyResponse currency, HttpServletRequest request) {
        return Transaction.builder()
                .currencyFrom(currency.getCurrencyFrom())
                .currencyTo(currency.getCurrencyTo())
                .dateTimeUtc(currency.getDateTimeUtc())
                .rate(currency.getRate())
                .user(getUser(request))
                .valueFrom(currency.getValueFrom())
                .build();
    }

    private UserMain getUser(HttpServletRequest request) {
        return userDetailsService.getUser(request);
    }
}
