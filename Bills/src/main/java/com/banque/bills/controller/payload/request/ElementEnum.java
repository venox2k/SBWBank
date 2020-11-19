package com.banque.bills.controller.payload.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElementEnum {

	@NotNull
	private int key;
	
	@NotNull
	private String value;
}
