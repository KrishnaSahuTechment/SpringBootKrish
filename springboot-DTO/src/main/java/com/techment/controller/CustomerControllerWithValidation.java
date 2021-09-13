package com.techment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.dto.CustomerDto;
//import com.techment.exception.ValidationException;
import com.techment.service.ICustomerService;

@RestController
@RequestMapping(value="/customerValidationController")
public class CustomerControllerWithValidation {

	@Autowired
	ICustomerService iCustomerService;
	
	@PostMapping("/addNewCustomer")
	public ResponseEntity<String> addNewCustomer(@Valid  @RequestBody CustomerDto customerDto,BindingResult bindingResult) throws MethodArgumentNotValidException
	{
		
		if(bindingResult.hasErrors())
		{
			
				
			 List<FieldError> errors = 	bindingResult.getFieldErrors();
				
			 List<String> errorList = new ArrayList<String>();
			 
			 for(FieldError f: errors)
			 {
				 
				 errorList.add(f.getDefaultMessage());
				 
				 System.out.println("==============errlist:"+errorList);
			 }
			 
//			 throw new ValidationException(errorList);
			 throw new com.techment.exception.ValidationException(errorList);
		 
		}
		
		
		iCustomerService.addCustomer(customerDto);
		
		return new ResponseEntity<String>(" new customer added....\n",HttpStatus.OK);
	
	}
	
}
