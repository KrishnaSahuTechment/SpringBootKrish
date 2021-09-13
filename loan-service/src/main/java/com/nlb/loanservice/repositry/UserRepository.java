package com.nlb.loanservice.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlb.loanservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
Optional  <User> findByUsernameAndPassword(String username,String password);

Optional  <User> findByToken(String token);
	
}
