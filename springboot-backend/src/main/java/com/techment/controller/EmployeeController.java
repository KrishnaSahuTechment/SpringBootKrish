package com.techment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.model.Employee;
import com.techment.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//build create employee REST API	
	@PostMapping("/add")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){		
		
//		public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
//		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
		
//		employeeService.saveEmployee(employee);
		return new ResponseEntity<String>("employee add....\n"+employeeService.saveEmployee(employee),HttpStatus.OK);
	}
	
	
	
	
	//build get all employees	
	@GetMapping("/all")
	public List<Employee> getAllemployees()
	{
		return employeeService.getAllEmployees();
		
	}
	
}
