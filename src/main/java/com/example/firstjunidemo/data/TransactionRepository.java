package com.example.firstjunidemo.data;

import com.example.firstjunidemo.domain.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Transaction findById(long id);

    @Query("select t from Transaction t where t.account.id = :id")
    List<Transaction> getTransactionsByAccountId(@Param("id") Long id);

    @Query("select t.subTransactions from Transaction t where t.id = :id")
    List<Transaction> getSubTransactionsById(@Param("id") Long id);

}
