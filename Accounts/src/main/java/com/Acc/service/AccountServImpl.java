package com.Acc.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Acc.Exceptions.AccountNotFoundException;
import com.Acc.Exceptions.SoldNotEnoughException;
import com.Acc.dao.AccountDao;
import com.Acc.entity.Account;


@Service
public class AccountServImpl implements AccountService {

	@Autowired
	AccountDao accountDao ;
	
	
	@Override
	public List<Account> getAllAccounts(String id) {
		return accountDao.getAllAccounts(id);
	}

	@Override
	public Account getAccount(String id) {
		Account acc = accountDao.getAccount(id);
		return acc;
	}

	@Override
	public void deleteAccount(String id) {
		
		Account tempAcc = accountDao.getAccount(id);
		 if(tempAcc == null)
		 {
			 throw new AccountNotFoundException("Account not found");
		 }
		accountDao.deleteAccount(id);

	}

	@Override
	public void insertAccount(Account acc) {
		accountDao.InsertAccount(acc);

	}
	
	public Account deposit(String id , int amount)
	{
		Account acc = accountDao.getAccount(id);
		System.out.println(acc.toString());
		int som = amount + acc.getSold() ;
		acc.setSold(som);
		accountDao.updateAccount(acc);		
		return acc ;
		
	}
	
	public Account withdraw(String id ,int amount)
	{
		Account acc = accountDao.getAccount(id);
		System.out.println(acc.toString());
		int som =  acc.getSold()-amount  ;
		if(som < 0)
		{
			throw new SoldNotEnoughException("Sold not Enough");
		}
		acc.setSold(som);
		accountDao.updateAccount(acc);		
		return acc ;
	}

}
