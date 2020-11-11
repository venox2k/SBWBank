package com.banque.auth.controller.payload.response;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

	@NonNull
	private String uuid;
	@NonNull
	private String name;
	@NonNull
	private String email;
	private String phone;
	private String gender;
	private String dob;
	private String eid;
}
