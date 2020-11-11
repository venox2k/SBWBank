package com.banque.bills.controller.payload.response;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.banque.bills.controller.payload.request.ElementEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillResponse {

	@Id
	private String uuid;
	private ElementEnum category;
	private String entity;
	private String account_no;
	private String amount;
	private String currency;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private Date date;
}
