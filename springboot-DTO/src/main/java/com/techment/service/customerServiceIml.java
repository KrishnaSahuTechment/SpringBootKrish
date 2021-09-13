package com.techment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.techment.dao.ICustomerDao;
import com.techment.dto.CustomerDto;

import com.techment.entity.Customer;
import com.techment.exception.IDNotFoundException;


@Service
public class CustomerServiceIml implements ICustomerService {

	@Autowired
	ICustomerDao Dao; 
	
//	@Autowired
//	CustomerDto customerDto;
	
	@Override
	public String addCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		
		Customer customer = new Customer();
		customer.setName(customerDto.getName());
		customer.setAddress(customerDto.getAddress());
		customer.setAge(customerDto.getAge());
		customer.setEmail(customerDto.getEmail());
		customer.setMobile(customerDto.getMobile());
		
		Dao.save(customer);
		
		
		return "Customer added";
	}

	

	@Override
	public List<CustomerDto> viewAllCustomer() {
		// TODO Auto-generated method stub
		
		List<Customer> customers = Dao.findAll();
		
		List<CustomerDto> customerDto = new ArrayList<CustomerDto>();
		
		
		for(Customer c : customers)
		{
			
			
			customerDto.add(new CustomerDto(c.getId(),c.getName(),c.getAge(),c.getAddress(),c.getEmail(),c.getMobile()));
		}
		
		
		return customerDto;
	}


	@Override
	public CustomerDto viewCustomerById(int id) throws IDNotFoundException{
		CustomerDto customerDto = new CustomerDto();		
		Customer c = Dao.getById(id);		
		CustomerDto customerDto2  = new CustomerDto(c.getId(),c.getName(),c.getAge(),c.getAddress(),c.getEmail(),c.getMobile());			
		return customerDto2;
	}



	@Override
	public String updateCustomerById(@RequestBody Customer  customer, @PathVariable int id) throws IDNotFoundException{
		// TODO Auto-generated method stub
							
				Customer c = Dao.getById(id);
				
		Dao.save(customer);
		
		return "customer details updated successfully";
	}



	@Override
	public String deleteCustomerById(int id) throws NoSuchElementException {
					
		Dao.deleteById(id);
		return "Delete successfully";
	}


	public void save(Customer customerDto) {
		Dao.save(customerDto);
		}
	



	

	
	



	
}
