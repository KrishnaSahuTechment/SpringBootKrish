package com.techment.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = IDNotFoundException.class)
	public ResponseEntity<Object> MyException(IDNotFoundException exception)
	{
		
		
		return new ResponseEntity<Object>(exception.getMsg(),HttpStatus.NOT_EXTENDED);
			
	}
	
	
	@ExceptionHandler(value = CustomerException.class)
	public ResponseEntity<Object> myCustomerException(IDNotFoundException exception)
	{
		return new ResponseEntity<Object>(exception.getMsg(),HttpStatus.NOT_EXTENDED);
			
	}
	
	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<List<String>> myValidationException(ValidationException exception)
	{
	
		return new ResponseEntity<List<String>>(exception.getMessages(),HttpStatus.BAD_REQUEST);
	}
	
}
