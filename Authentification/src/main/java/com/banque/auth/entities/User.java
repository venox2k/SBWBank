package com.banque.auth.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8749549302366784056L;

	@Id
	private String uuid;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private String dob;
	private String eid;
	private String password;

}
