package com.sbwbank.transactions.service;

import java.util.List;

import com.sbwbank.transactions.entity.Transaction;

public interface TransactionService {

	List<Transaction> getUserTransactions(String uuid);

	void dropTransactions();

	void createTransaction(Transaction transaction);

}
