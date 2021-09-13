package com.nlb.loanservice.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlb.loanservice.dto.UserDto;
import com.nlb.loanservice.entity.User;
import com.nlb.loanservice.exception.InvalidUserException;
import com.nlb.loanservice.repositry.UserRepository;
import com.nlb.loanservice.util.SiteUtil;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SiteUtil siteUtil;
	
	@Override
	public UserDto login(String username, String password) throws NoSuchElementException {
		
		
		try
		{
		
		User user = userRepository.findByUsernameAndPassword(username, password).get();
		
		String token = siteUtil.generateToken();
		
		user.setToken(token);
		
		UserDto userDto = new UserDto(user.getUsername(),user.getPassword(),token);
			

		userRepository.save(user);
		return userDto;
		  
		}catch(NoSuchElementException e)
		{
			throw  new InvalidUserException("invalid username or password ");
		
		}

}

	@Override
	public UserDto login(String token) throws NoSuchElementException{
		// TODO Auto-generated method stub
		
		
		try
		{
		
		User user = userRepository.findByToken(token).get();
	
			
		UserDto userDto = new UserDto(user.getUsername(),user.getPassword());
			

		userRepository.save(user);
		return userDto;
		  
		}catch(NoSuchElementException e)
		{
			throw  new InvalidUserException("invalid token ");
		
		}
		
	}

}