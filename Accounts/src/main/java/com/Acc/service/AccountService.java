package com.Acc.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.Acc.entity.Account;


public interface AccountService {

	public List<Account> getAllAccounts(String id) ;
	
	public Account getAccount(String id) ;
	
	public void deleteAccount(String id)  ;
	
	public void insertAccount(Account acc);
	
	 
	public Account withdraw(String id , int amount);
	public Account deposit(String id ,int amount);



}
