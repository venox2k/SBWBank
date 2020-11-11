package com.banque.bills.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banque.bills.controller.payload.request.BillRequest;
import com.banque.bills.controller.payload.response.BillResponse;
import com.banque.bills.service.BillService;


@RestController
@RequestMapping("/api/bills")
public class BillsController {
	
	@Autowired
	private BillService billService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createBill(@Valid @RequestBody BillRequest billRequest) {
		try {
			BillResponse billResponse = billService.createBill(billRequest);
			return new ResponseEntity<Object>(billResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<?> getBills(@Valid @RequestBody String uuid) {
		try {
			List<BillResponse> bills=billService.getBills(uuid);
			return new ResponseEntity<Object>(bills,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	

	@RequestMapping(value = "/drop", method = RequestMethod.GET)
	public ResponseEntity<?> drop() {
		try {
			List<BillResponse> bills=billService.drop();
			return new ResponseEntity<Object>(bills,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

}
