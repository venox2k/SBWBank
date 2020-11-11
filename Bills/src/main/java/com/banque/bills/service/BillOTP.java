package com.banque.bills.service;

import java.util.List;

import com.banque.bills.controller.payload.response.BillResponse;
import com.banque.bills.entities.Bill;

public interface BillOTP {

	public BillResponse billOTP(Bill bill);
	
	public List<BillResponse> billsOTP(List<Bill> bills);
}
