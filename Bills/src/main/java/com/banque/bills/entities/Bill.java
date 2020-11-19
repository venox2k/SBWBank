package com.banque.bills.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "bills")
public class Bill implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8749549302366784056L;

	@Id
	private String bill_Id;
	private String uuid;
	private CategoryEnum category;
	private String entity;
	private String account_no;
	private Double amount;
	private String currency;
	private Date date;

}
