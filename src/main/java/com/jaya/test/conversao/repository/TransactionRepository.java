package com.jaya.test.conversao.repository;

import com.jaya.test.conversao.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

interface TransactionRepository extends JpaRepository<Transaction, Long> {
}