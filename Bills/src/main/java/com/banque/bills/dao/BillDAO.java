package com.banque.bills.dao;

import java.util.List;

import com.banque.bills.entities.Bill;

public interface BillDAO {

	public void createBill(Bill bill);
	
	public List<Bill> getBills(String uuid);

	public List<Bill> drop();
	
}