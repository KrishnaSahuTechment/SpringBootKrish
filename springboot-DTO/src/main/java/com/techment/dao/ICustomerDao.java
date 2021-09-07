package com.techment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techment.entity.Customer;

@Repository
public interface ICustomerDao  extends JpaRepository<Customer, Integer>{

	
}
