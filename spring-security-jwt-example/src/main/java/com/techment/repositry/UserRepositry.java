package com.techment.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techment.entity.User;

public interface UserRepositry extends JpaRepository<User, Integer>{

	User findByUserName(String username);
		
}
