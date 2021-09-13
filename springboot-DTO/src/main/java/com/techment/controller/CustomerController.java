package com.techment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.dto.CustomerDto;
import com.techment.entity.Customer;

import com.techment.exception.IDNotFoundException;
import com.techment.exception.ValidationException;
import com.techment.service.ICustomerService;

@RestController
@RequestMapping(value="/customerController")
public class CustomerController {

	@Autowired
	ICustomerService iCustomerService;
	
	
	//build get all employees	
		@GetMapping("/viewAllCustomer")
		public List<CustomerDto> viewAllCustomer(@RequestHeader String token)
		{
			return iCustomerService.viewAllCustomer();			
		}		
		
		@PostMapping("/addCustomer")
		public ResponseEntity<String> saveCustomerDto(@RequestBody CustomerDto customerDto){		
			
//			public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
//			return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
			
//			employeeService.saveEmployee(employee);
			iCustomerService.addCustomer(customerDto);			
			
			return new ResponseEntity<String>("customer add....\n",HttpStatus.OK);		
		}		
		
		
		@GetMapping("/customerById/{id}")
		public CustomerDto getByIdCustomerDto(@PathVariable int id)
		{
			try
			{
			CustomerDto customer = iCustomerService.viewCustomerById(id);
			return customer;
			}catch(NoSuchElementException e)
			{
				throw new IDNotFoundException("No Id present to view");
				
			}			
					
		}
		
		
		@DeleteMapping("/DeleteCustomerById/{id}")
		public String deleteId(@PathVariable int id)
		{
			try {
				iCustomerService.deleteCustomerById(id);
				return "Customer details Deleted successfully";

			} catch (Exception e) {
			
				throw new IDNotFoundException("No Such Id Details Present for deleting");
			}
			
		}
		
		
		@PutMapping("/update/{id}")
		public String updateCustomerById(@RequestBody Customer customerDto ,@PathVariable int id)
		{		
			try
			{									
			return iCustomerService.updateCustomerById(customerDto, id);			
			}catch(NoSuchElementException e)
			{
				throw new IDNotFoundException("No Id present to update");
			}			
		}
		
	
		@ExceptionHandler(value = IDNotFoundException.class)
		public ResponseEntity<Object> MyException(IDNotFoundException exception)
		{			
			return new ResponseEntity<Object>(exception.getMsg(),HttpStatus.NOT_EXTENDED);				
		}
		
		
		
}
