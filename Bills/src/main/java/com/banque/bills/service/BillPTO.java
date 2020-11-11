package com.banque.bills.service;

import com.banque.bills.controller.payload.request.BillRequest;
import com.banque.bills.entities.Bill;

public interface BillPTO {

	public Bill billPTO(BillRequest userPayload);
}
