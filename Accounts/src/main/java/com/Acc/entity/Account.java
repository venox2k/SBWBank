package com.Acc.entity;

import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Accounts")
public class Account {

    @Transient
    public static final String SEQUENCE_NAME = "Accounts_sequence";
 
  

	@Id
	private String id;

	@Field(value = "uuid")
	private String uuid;

	@Field(value = "type")
	private String type;

	@Field(value = "currency")
	private String currency;

	@Field(value = "Sold")
	private int Sold;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getSold() {
		return Sold;
	}

	public void setSold(int sold) {
		Sold = sold;
	}

	public Account(String id, String uuid, String type, String currency, int sold) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.type = type;
		this.currency = currency;
		Sold = sold;
	}

	public Account() {
		super();
	}

}
