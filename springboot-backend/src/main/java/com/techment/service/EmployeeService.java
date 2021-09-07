package com.techment.service;
import java.util.*;

import com.techment.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
}
