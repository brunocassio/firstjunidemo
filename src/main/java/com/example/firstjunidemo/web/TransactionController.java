package com.example.firstjunidemo.web;

import com.example.firstjunidemo.domain.Transaction;
import com.example.firstjunidemo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction/account/{id}")
    List<Transaction> listTransactionsByAccountId(@PathVariable Long id) {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        List<Transaction> transactions = transactionService.getTransactionsByAccountId(id, firstPageWithTwoElements);
        return transactions;
    }

    @GetMapping("/transaction/{id}")
    List<Transaction> listSubTransactions(@PathVariable Long id) {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        return transactionService.getSubTransactionsById(id, firstPageWithTwoElements);
    }
}
