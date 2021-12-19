package com.example.firstjunidemo.bootstrap;

import com.example.firstjunidemo.data.AccountRepository;
import com.example.firstjunidemo.data.TransactionRepository;
import com.example.firstjunidemo.domain.Account;
import com.example.firstjunidemo.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        addPayPalAccount();
        addRevolutAccount();
    }

    private void addPayPalAccount() {
        Account accountPayPal = new Account();
        accountPayPal.setName("Paypal");

        Transaction transactionPayPalEUR1 = new Transaction();
        transactionPayPalEUR1.setAccount(accountPayPal);
        transactionPayPalEUR1.setAmount(-2.0);
        transactionPayPalEUR1.setCategory("Payment gateways");
        transactionPayPalEUR1.setDate(new Date());
        transactionPayPalEUR1.setDescription("The New York Times Co.");
//        transactionPayPalEUR1.setParentTransactions(transactionPayPalEUR1);

        Transaction transactionPayPalEUR2 = new Transaction();
        transactionPayPalEUR2.setAccount(accountPayPal);
        transactionPayPalEUR2.setAmount(2.0);
        transactionPayPalEUR2.setCategory("Payment gateways");
        transactionPayPalEUR2.setDate(new Date());
        transactionPayPalEUR2.setDescription("From British Pound");
//        transactionPayPalEUR2.setParentTransactions(transactionPayPalEUR2);

        Transaction transactionPayPalGBP3 = new Transaction();
        transactionPayPalGBP3.setAccount(accountPayPal);
        transactionPayPalGBP3.setAmount(1.86);
        transactionPayPalGBP3.setCategory("Payment gateways");
        transactionPayPalGBP3.setDate(new Date());
        transactionPayPalGBP3.setDescription("To Euro");
//        transactionPayPalGBP3.setParentTransactions(transactionPayPalGBP3);

        Transaction transactionPayPalGBP4 = new Transaction();
        transactionPayPalGBP4.setAccount(accountPayPal);
        transactionPayPalGBP4.setAmount(-1.86);
        transactionPayPalGBP4.setCategory("Payment gateways");
        transactionPayPalGBP4.setDate(new Date());
        transactionPayPalGBP4.setDescription("Credit Card");
//        transactionPayPalGBP4.setParentTransactions(transactionPayPalGBP4);

        List<Transaction> payPalTransactions = List.of(transactionPayPalEUR1, transactionPayPalEUR2, transactionPayPalGBP3, transactionPayPalGBP4);
        accountPayPal.setTransactions(payPalTransactions);

        accountRepository.save(accountPayPal);
    }

    private void addRevolutAccount() {
        Account accountRevolut = new Account();
        accountRevolut.setName("Revolut");

        Transaction transactionRevolutNYTSubscription = new Transaction();
        transactionRevolutNYTSubscription.setAccount(accountRevolut);
        transactionRevolutNYTSubscription.setAmount(2.1);
        transactionRevolutNYTSubscription.setCategory("Banks");
        transactionRevolutNYTSubscription.setDate(new Date());
        transactionRevolutNYTSubscription.setDescription("Paypal *ny The New York Times Co.");

        Account accountPayPal = accountRepository.findByName("Paypal");

        List<Transaction> subTransactionRevolutNYTSubscription = new ArrayList<>();

        for (Transaction payPal : accountPayPal.getTransactions()) {
            subTransactionRevolutNYTSubscription.add(payPal);
        }

        transactionRevolutNYTSubscription.setSubTransactions(subTransactionRevolutNYTSubscription);

        List<Transaction> transactionsRevolut = new ArrayList<>();
        transactionsRevolut.add(transactionRevolutNYTSubscription);


        accountRevolut.setTransactions(transactionsRevolut);

        accountRepository.save(accountRevolut);
    }
}
