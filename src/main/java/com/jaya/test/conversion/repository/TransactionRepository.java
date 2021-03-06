package com.jaya.test.conversion.repository;

import com.jaya.test.conversion.controller.response.TransactionUserResponse;
import com.jaya.test.conversion.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT new com.jaya.test.conversion.controller.response.TransactionUserResponse( " +
            "t.id, t.currencyFrom, t.currencyTo, t.valueFrom, t.rate, t.dateTimeUtc) " +
            "FROM Transaction t " +
            "WHERE t.user.id = ?1")
    List<TransactionUserResponse> findAllByUserId(Long userId);
}
