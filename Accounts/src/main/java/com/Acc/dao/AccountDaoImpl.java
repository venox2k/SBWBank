package com.Acc.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.Acc.entity.Account;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	
	@Autowired
	 MongoTemplate mongoTemplate ;
	
	
	@Override
	public List<Account> getAllAccounts(String uuid) {
		
		Query query = new Query(Criteria.where("uuid").is(uuid));
		List<Account> accounts = mongoTemplate.find(query, Account.class);
		return accounts;
	}
	
	@Override
	public Account getAccount(String id) {
		
		Query query = new Query(Criteria.where("_id").is(id));
		Account acc =  mongoTemplate.findOne(query, Account.class);
		return acc ;
	}
	
	@Override
	public void deleteAccount(String id) {
		
		Query query = new Query(Criteria.where("_id").is(id));
		Account acc =  mongoTemplate.findOne(query, Account.class);
		mongoTemplate.remove(acc);
		
	}
	
	@Override
	public void InsertAccount(Account acc) {
		
		mongoTemplate.save(acc);
		
	}
	
	

	@Override
	public void updateAccount(Account acc) {
		// TODO Auto-generated method stub
		mongoTemplate.save(acc);

	}
	
	
}
