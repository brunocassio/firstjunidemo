package com.example.firstjunidemo.web;

import com.example.firstjunidemo.domain.Transaction;
import com.example.firstjunidemo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction/account/{}")
    List<Transaction> listTransactionsByAccountId(@PathVariable Long id) {
        return transactionService.getTransactionsByAccountId(id);
    }

    @GetMapping("/transaction/{}")
    List<Transaction> listSubTransactions(@PathVariable Long id) {
        return transactionService.getSubTransactionsById(id);
    }
}
