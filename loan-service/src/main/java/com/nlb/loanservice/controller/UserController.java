package com.nlb.loanservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlb.loanservice.dto.UserDto;
import com.nlb.loanservice.entity.LoanApplication;
import com.nlb.loanservice.entity.User;
import com.nlb.loanservice.service.ILoanApplicationService;
import com.nlb.loanservice.service.IUserService;

@RestController
@RequestMapping(value =  "/login")
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	ILoanApplicationService iLoanApplicationService;
	
	
	@PostMapping(value="/userlogin")
	public ResponseEntity<UserDto> login(@RequestBody User user )
	{
		
//		if(user.getToken() != null)
//		{
//			UserDto userDtoWithToken =  userService.login(user.getToken());
//			return new ResponseEntity<UserDto>(userDtoWithToken,HttpStatus.OK);			
//		}
//		else
//		{		
		UserDto userDto =  userService.login(user.getUsername(), user.getPassword());		
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);	
//		}
	}
	
	
	
	
	
}
