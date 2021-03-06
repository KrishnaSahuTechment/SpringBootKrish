package com.techment.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techment.model.Employee;
import com.techment.repositry.EmployeeRepositry;
import com.techment.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepositry employeeRepositry;
	
	
	
	
	public EmployeeServiceImpl(EmployeeRepositry employeeRepositry) {
		super();
		this.employeeRepositry = employeeRepositry;
	}




	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepositry.save(employee);
	}




	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		
		return employeeRepositry.findAll();
	}

}
