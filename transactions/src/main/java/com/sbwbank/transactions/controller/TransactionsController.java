package com.sbwbank.transactions.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbwbank.transactions.entity.Transaction;
import com.sbwbank.transactions.entity.Uuid;
import com.sbwbank.transactions.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
	@Autowired
	private TransactionService transactionService;
	
	private LinkedHashMap<String, String> successMessage;
	
	@PostConstruct
	public void initController() {
		successMessage = new LinkedHashMap<String, String>();
		successMessage.put("message", "Done !");
	}
	
	@PostMapping("/create")
	public LinkedHashMap<String, String> createTransaction(@RequestBody Transaction transaction) {
		transactionService.createTransaction(transaction);
		return successMessage;
	}
	
	@PostMapping("/get")
	public List<Transaction> getUserTransactions(@RequestBody Uuid myUuid){
		return transactionService.getUserTransactions(myUuid.getUuid());
	}
	
	@GetMapping("/drop")
	public LinkedHashMap<String, String> dropTransactions() {
		transactionService.dropTransactions();
		return successMessage;
	}
}
