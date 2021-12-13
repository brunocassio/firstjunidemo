package com.example.firstjunidemo.data;

import com.example.firstjunidemo.domain.Transaction;
import org.springframework.data.repository.CrudRepository;


public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Transaction findById(long id);



}
