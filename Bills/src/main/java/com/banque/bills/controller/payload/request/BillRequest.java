package com.banque.bills.controller.payload.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
@Getter
@Setter
public class BillRequest {

	@NonNull
	private String uuid;
	@NonNull
	private ElementEnum category;
	private String entity;
	@NonNull
	private String account_no;
	private String amount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private Date date;
}
