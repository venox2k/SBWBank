package com.banque.bills.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.banque.bills.entities.Bill;
import com.banque.bills.exception.BadRequestException;

@Repository
public class BillDAOImpl implements BillDAO {
	@Autowired
	MongoTemplate mongoTemplate;
	
	private static final String COLLECTION_NAME="bills";

	public void createBill(Bill bill) {
		try {
			mongoTemplate.insert(bill,COLLECTION_NAME);
		}catch (Exception e) {
			throw new BadRequestException("internal server");
		}
	}

	public List<Bill> getBills(String uuid) {
		
		try {
			Query query=new Query(Criteria.where("uuid").is(uuid));
			List<Bill> bills=mongoTemplate.find(query, Bill.class, COLLECTION_NAME);
			return bills;
			
		} catch (Exception e) {
			throw new BadRequestException("internal server");
		}
	}

	public List<Bill> drop() throws BadRequestException {
		try {
			List<Bill> bills=mongoTemplate.findAll(Bill.class, COLLECTION_NAME);
			return bills;
		} catch (Exception e) {
			throw new BadRequestException("internal server");
		}
	}
}
