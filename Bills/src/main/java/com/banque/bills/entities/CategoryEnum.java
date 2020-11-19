package com.banque.bills.entities;

import lombok.Getter;

@Getter
public enum CategoryEnum {
	UTILITIES(1,"utilities"),
	HOME_ENTERTAINMENT(2,"home_entertainment"),
	MOBILE_PHONE(3,"mobile_phone"),
	CREDIT_CARD(4,"credit_card");
   
	private int key;
	private String value;
	
	private CategoryEnum(int key,String value) {
		this.key=key;
		this.value=value;
	}
	
	public static CategoryEnum getEnumeration(Integer key) {
		CategoryEnum[] categories = values();
		for (CategoryEnum category : categories) {
			if (key == category.getKey())
				return category;
		}
		return null;
	}
}
