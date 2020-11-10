package com.sbwbank.transactions.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sbwbank.transactions.entity.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void save(Transaction transaction) {
		transaction.setId(transaction.getUuid().concat(transaction.getDate()));
		mongoTemplate.save(transaction);
	}

	@Override
	public void dropAll() {
		mongoTemplate.dropCollection(Transaction.class);
	}

	@Override
	public List<Transaction> fetchByUUID(String uuid) {
		return mongoTemplate.find(Query.query(Criteria.where("uuid").is(uuid)), Transaction.class);
	}
}
