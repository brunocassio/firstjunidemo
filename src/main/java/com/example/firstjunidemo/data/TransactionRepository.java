package com.example.firstjunidemo.data;

import com.example.firstjunidemo.domain.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {

    @Query("select t from Transaction t where t.account.id = :id")
    List<Transaction> getTransactionsByAccountId(@Param("id") Long id, Pageable pageable);

    @Query("select t.subTransactions from Transaction t where t.id = :id")
    List<Transaction> getSubTransactionsById(@Param("id") Long id, Pageable pageable);

}
