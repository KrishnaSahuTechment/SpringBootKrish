package com.techment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techment.entity.Employee;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee, Integer>{
	
	public List<Employee> findByName(String name);
	public List<Employee> findByNameAndDept(String name,String dept);
	public List<Employee> findByNameOrEmpId(String name,int empId);	
	public List<Employee> findBySalaryBetween(double startSalary,double endSalary);
	public List<Employee> findBySalaryLessThan(double Salary);
	public List<Employee> findBySalaryLessThanEqual(double Salary);
	public List<Employee> findBySalaryGreaterThan(double Salary);
	public List<Employee> findBySalaryGreaterThanEqual(double Salary);
	public List<Employee> findByNameIsNull(String name);
	
	
	
}
