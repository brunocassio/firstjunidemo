package com.example.firstjunidemo.service;

import com.example.firstjunidemo.domain.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getTransactionsByAccountId(long id);
}
