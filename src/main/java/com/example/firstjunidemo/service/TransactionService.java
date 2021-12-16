package com.example.firstjunidemo.service;

import com.example.firstjunidemo.domain.Transaction;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransactionService {

    List<Transaction> getTransactionsByAccountId(long id, Pageable pageable);

    List<Transaction> getSubTransactionsById(long id, Pageable pageable);
}
