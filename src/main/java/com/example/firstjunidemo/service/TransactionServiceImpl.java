package com.example.firstjunidemo.service;

import com.example.firstjunidemo.data.TransactionRepository;
import com.example.firstjunidemo.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getTransactionsByAccountId(long id, Pageable pageable) {
        return transactionRepository.getTransactionsByAccountId(id, pageable);
    }

    @Override
    public List<Transaction> getSubTransactionsById(long id, Pageable pageable) {
        return transactionRepository.getSubTransactionsById(id, pageable);
    }
}
