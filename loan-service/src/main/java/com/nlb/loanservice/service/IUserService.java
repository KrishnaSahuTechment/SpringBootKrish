package com.nlb.loanservice.service;

import com.nlb.loanservice.dto.UserDto;

public interface IUserService {

	
	UserDto login(String username,String password);
	
	UserDto login(String token);
	
	
}
