package com.banque.bills.service;

import org.springframework.stereotype.Service;

import com.banque.bills.controller.payload.request.BillRequest;
import com.banque.bills.entities.Bill;
import com.banque.bills.entities.CategoryEnum;

@Service
public class BillPTOImpl implements BillPTO {

	public Bill billPTO(BillRequest billRequest) {
		Bill bill=new Bill();
		bill.setBill_Id(billRequest.getUuid().concat(String.valueOf(billRequest.getDate())));
		bill.setUuid(billRequest.getUuid());
		bill.setEntity(billRequest.getEntity());
		bill.setDate(billRequest.getDate());
		bill.setAmount(Double.valueOf(billRequest.getAmount()));
		bill.setAccount_no(billRequest.getAccount_no());
		bill.setCategory(CategoryEnum.getEnumeration(billRequest.getCategory().getKey()));
		return bill;
	}

}
