package com.jaya.test.conversao.controller;

import com.jaya.test.conversao.controller.response.TransactionUserResponse;
import com.jaya.test.conversao.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @ResponseStatus(OK)
    @GetMapping
    public List<TransactionUserResponse> listTransactionsByUser(HttpServletRequest request) {
        return service.getTransactions(request);
    }
}
