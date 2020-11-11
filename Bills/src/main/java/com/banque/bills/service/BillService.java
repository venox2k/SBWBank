package com.banque.bills.service;

import java.util.List;

import com.banque.bills.controller.payload.request.BillRequest;
import com.banque.bills.controller.payload.response.BillResponse;

public interface BillService {

	public BillResponse createBill(BillRequest billRequest);

	public List<BillResponse> getBills(String uuid);
	
	public List<BillResponse> drop();
}
