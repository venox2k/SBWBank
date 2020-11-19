package com.banque.bills.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banque.bills.controller.payload.request.ElementEnum;
import com.banque.bills.controller.payload.response.BillResponse;
import com.banque.bills.entities.Bill;
@Service
public class BillOTPImpl implements BillOTP {

	public BillResponse billOTP(Bill bill) {
		BillResponse billResponse=new BillResponse();
		billResponse.setAccount_no(bill.getAccount_no());
		billResponse.setAmount(String.valueOf(bill.getAmount()));
		ElementEnum element=new ElementEnum();
		element.setKey(bill.getCategory().getKey());
		element.setValue(bill.getCategory().getValue());
		billResponse.setCategory(element);
		billResponse.setCurrency(bill.getCurrency());
		billResponse.setDate(bill.getDate());
		billResponse.setEntity(bill.getEntity());
		billResponse.setUuid(bill.getUuid());
		return billResponse;
	}

	public List<BillResponse> billsOTP(List<Bill> bills) {
		List<BillResponse> billsResponse=null;
		if(bills!=null) {
			billsResponse=new ArrayList<BillResponse>();
			for (Bill bill : bills) {
				BillResponse billResponse=billOTP(bill);
				billsResponse.add(billResponse);
			}
		}
		return billsResponse;
	}

}
