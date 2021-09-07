package com.techment.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techment.model.Employee;



public interface EmployeeRepositry extends JpaRepository<Employee, Long> {

}
