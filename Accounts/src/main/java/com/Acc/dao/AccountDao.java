package com.Acc.dao;


import java.util.List;

import com.Acc.entity.Account;

public interface AccountDao  {

	public List<Account> getAllAccounts(String id);

	public Account getAccount(String id);

	public void deleteAccount(String id);


	public void InsertAccount(Account acc);
	
	public void updateAccount(Account acc);

}
