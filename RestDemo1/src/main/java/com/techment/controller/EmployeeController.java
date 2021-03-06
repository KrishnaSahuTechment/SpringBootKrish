package com.techment.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.entity.Employee;

@RestController
@RequestMapping(value = "/employeeController")
public class EmployeeController {

	ArrayList<Employee> employees= new ArrayList<Employee>();
	
	
	
	
	public EmployeeController() {
		super();		
		employees.add(new Employee(1,"krishna","hr"));
		employees.add(new Employee(2,"Anmol","QA"));
		employees.add(new Employee(3,"Prateek","hr"));
						
	}


	public EmployeeController(ArrayList<Employee> employees) {
			
		
		this.employees = employees;
	}


	@GetMapping(value="/showMessage")
	public String display()
	{
		return "this is my first demo";
	}
	
	
	@GetMapping(value="/showAllEmployees")
	public ArrayList<Employee>  showEmployees()
	{
		
		
		return employees;
	}
	
	
	@PostMapping(value="/addNewEmplyee")
	public String addEmployee(@RequestBody Employee employee)
	{
		System.out.println("empid "+employee.getId()+" "+employee.getName()+"dept "+employee.getDept());
		employee.add(employees);
		
		return "employee added";
	}
	
	
	
}
