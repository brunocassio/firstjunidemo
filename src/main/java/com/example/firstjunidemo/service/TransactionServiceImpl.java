package com.example.firstjunidemo.service;

import com.example.firstjunidemo.data.TransactionRepository;
import com.example.firstjunidemo.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getTransactionsByAccountId(long id) {
        return transactionRepository.getTransactionsByAccountId(id);
    }

    @Override
    public List<Transaction> getSubTransactionsById(long id) {
        return null;
    }
}
