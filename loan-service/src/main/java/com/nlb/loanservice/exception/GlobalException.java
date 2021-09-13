package com.nlb.loanservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nlb.loanservice.exception.InvalidUserException;



@RestControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(value = LoanApplicationAlreadyExistsException.class )
	public ResponseEntity<String> myException1 (LoanApplicationAlreadyExistsException  exception)
	{		
		return new ResponseEntity<String>(exception.getMsg(),HttpStatus.CONFLICT);		
	}
	
	@ExceptionHandler(value = LoanApplicationNotFoundException.class )
	public ResponseEntity<String> myException2 (LoanApplicationNotFoundException exception)
	{		
		return new ResponseEntity<String>(exception.getMsg(),HttpStatus.NOT_FOUND);		
	}
	
	@ExceptionHandler(value = InvalidUserException.class )
	public ResponseEntity<String> myException (InvalidUserException exception)
	{
//		InvalidException	
		
		return new ResponseEntity<String>(exception.getMsg(),HttpStatus.UNAUTHORIZED);		
	}
	
}
