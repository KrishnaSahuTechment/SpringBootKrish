package com.techment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.dao.IEmployeeDao;
import com.techment.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeDao iemployeeDao;
	
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		iemployeeDao.save(employee);
		return "employee Added";
	}

	@Override
	public List<Employee> viewAllEmployee() {
		// TODO Auto-generated method stub
		return iemployeeDao.findAll();
	}

	@Override
	public Employee viewEmployeeById(int id) {
		// TODO Auto-generated method stub
		return iemployeeDao.findById(id).get();
	}

	@Override
	public Employee updateEmployeeById(int id) {
		// TODO Auto-generated method stub
		
		Employee emp = iemployeeDao.getById(id);
		
		
		return iemployeeDao.save(emp);
	}

	
	

	
}
