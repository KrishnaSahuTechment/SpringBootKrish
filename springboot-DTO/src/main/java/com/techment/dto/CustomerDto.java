package com.techment.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class CustomerDto {

	
	private int id;
	
	@Size(min = 3,message = "name should minimum 3 characters")
	private String name;
	
	
	private int age;
	
	@NotEmpty(message = "Address should not be empty")
	private String address;
	
//	@Email(message="give in proper email formate")
	private String email;
	
	@Size(min = 10,max=10,message = "It should be 10 digit")
	private String mobile;
	
	public CustomerDto() {
		super();
	}

	public CustomerDto(String name, int age, String address, String email, String mobile) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}

	
	
	public CustomerDto(int id, String name, int age, String address, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
	
}
