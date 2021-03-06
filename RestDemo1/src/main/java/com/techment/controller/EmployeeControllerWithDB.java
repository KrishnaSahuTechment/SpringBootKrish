package com.techment.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.entity.Employee;
import com.techment.exception.IDNotFoundException;

import com.techment.service.IEmployeeService;

@RestController
@RequestMapping("/empController")
public class EmployeeControllerWithDB {

	@Autowired
	IEmployeeService iEmployeeService;
	
	
	@GetMapping("/viewAllEmployee")
	public List<Employee> viewAllWmployee()	{
		return iEmployeeService.viewAllEmployee();		
	}
	
	
	@PostMapping("/addNewEmployee")
	 public String addEmployee(@RequestBody  Employee employee)	{			
		 return iEmployeeService.addEmployee(employee);
	}
	 
	
	@GetMapping("/viewEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable int id){
			
		
		try
		{
		return iEmployeeService.viewEmployeeById(id);
		
		}catch(NoSuchElementException e)
		{
			throw new IDNotFoundException("No Id present");
			
		}	
		
	}
	
	 
	@PutMapping("/update/{id}")
	public Employee updateEmployeeById(@RequestBody Employee employee,@PathVariable int id)
	{
		
		try
		{		
						
		return iEmployeeService.updateEmployeeById(id);
		
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
