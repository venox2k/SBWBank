package com.sbwbank.transactions.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Transactions")
public class Transaction {
	
	@Id
	private String id;
	
	@Field("uuid")
	private String uuid;
	
	@Field("amount")
	private double amount;
	
	@Field("currency")
	private String currency;
	
	@Field("description")
	private String description;
	
	@Field("date")
	private String date;
	
	@Field("category")
	private String category;

	public Transaction() {}

	@PersistenceConstructor
	public Transaction(String id, String uuid, double amount, String currency, String description, String date, String category) {
		this.id = id;
		this.uuid = uuid;
		this.amount = amount;
		this.currency = currency;
		this.description = description;
		this.date = date;
		this.category = category;
	}

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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Transaction [id=" + id + ", uuid=" + uuid + ", amount=" + amount + ", currency=" + currency
				+ ", description=" + description + ", date=" + date + ", category=" + category + "]";
	}

}
