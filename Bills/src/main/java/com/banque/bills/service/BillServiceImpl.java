package com.banque.bills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banque.bills.controller.payload.request.BillRequest;
import com.banque.bills.controller.payload.response.BillResponse;
import com.banque.bills.dao.BillDAO;
import com.banque.bills.entities.Bill;
import com.banque.bills.exception.BadRequestException;
@Service
public class BillServiceImpl implements BillService {
	@Autowired
	private BillDAO billDAO;
	@Autowired
	private BillPTO billPOT;
	@Autowired
	private BillOTP billOTP;

	public BillResponse createBill(BillRequest billRequest) {
		Bill bill=billPOT.billPTO(billRequest);
		billDAO.createBill(bill);
		BillResponse billResponse=billOTP.billOTP(bill);
		return billResponse;
	}

	public List<BillResponse> getBills(String uuid) throws BadRequestException {
		List<Bill> bills=billDAO.getBills(uuid);
		List<BillResponse> billsResponses=billOTP.billsOTP(bills);
		if(billsResponses !=null)
			return billsResponses;
		else
			throw new BadRequestException("la liste des bills est vide");
		
	}

	public List<BillResponse> drop() {
		List<Bill>  bills=billDAO.drop();
		List<BillResponse> billsResponses=billOTP.billsOTP(bills);
		if(billsResponses !=null)
			return billsResponses;
		else
			throw new BadRequestException("la liste des bills est vide");
	}

}
