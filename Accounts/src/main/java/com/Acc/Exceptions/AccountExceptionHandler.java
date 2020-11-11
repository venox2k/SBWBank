package com.Acc.Exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountExceptionHandler {

	
	@ExceptionHandler(value= {SoldNotEnoughException.class})
	public ResponseEntity<AccountException> handleSoldNotEnoughException(SoldNotEnoughException e)
	{
		
		
		AccountException accExp = new AccountException(e.getMessage(), e,HttpStatus.NOT_MODIFIED, ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(accExp,HttpStatus.NOT_MODIFIED);
		
	}
	
	@ExceptionHandler(value= {AccountNotFoundException.class})
	public ResponseEntity<AccountException> handleAccountNotFoundException(AccountNotFoundException e)
	{
		
		
		AccountException accExp = new AccountException(e.getMessage(), e,HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(accExp,HttpStatus.NOT_FOUND);
		
	}
}
