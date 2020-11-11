package com.Acc.Exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class AccountException {

	private final String message ;
	private final Throwable  throwable ;
	private final HttpStatus httpstatus ;
	private final ZonedDateTime timestamp ;
	public AccountException(String message, Throwable throwable, HttpStatus httpstatus, ZonedDateTime timestamp) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpstatus = httpstatus;
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public Throwable getThrowable() {
		return throwable;
	}
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
	
}
