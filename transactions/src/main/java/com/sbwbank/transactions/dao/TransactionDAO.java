package com.sbwbank.transactions.dao;

import java.util.List;

import com.sbwbank.transactions.entity.Transaction;

public interface TransactionDAO {

	void save(Transaction transaction);

	void dropAll();

	List<Transaction> fetchByUUID(String uuid);

}
