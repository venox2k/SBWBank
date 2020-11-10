package com.sbwbank.transactions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbwbank.transactions.dao.TransactionDAO;
import com.sbwbank.transactions.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;

	@Override
	public List<Transaction> getUserTransactions(String uuid) {
		return transactionDAO.fetchByUUID(uuid);
	}

	@Override
	public void dropTransactions() {
		transactionDAO.dropAll();
	}

	@Override
	public void createTransaction(Transaction transaction) {
		if(transaction.getUuid() == null || transaction.getCategory() == null || transaction.getCurrency() == null || transaction.getDate() == null || transaction.getDescription() == null)
			return;
		transactionDAO.save(transaction);
	}
}
