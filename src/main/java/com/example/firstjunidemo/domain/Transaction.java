package com.example.firstjunidemo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Transaction parentTransactions;

    @OneToMany(mappedBy = "parentTransactions")
    @JsonIgnore
    private List<Transaction> subTransactions;

    private String description;

    private Double amount;

    private String category;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Transaction getParentTransactions() {
        return parentTransactions;
    }

    public void setParentTransactions(Transaction parentTransactions) {
        this.parentTransactions = parentTransactions;
    }

    public List<Transaction> getSubTransactions() {
        return subTransactions;
    }

    public void setSubTransactions(List<Transaction> subTransactions) {
        this.subTransactions = subTransactions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
