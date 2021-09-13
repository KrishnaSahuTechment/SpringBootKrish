package com.techment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.dto.UserDto;
import com.techment.entity.User;
import com.techment.service.IUserService;

@RestController
@RequestMapping(value =  "/login")
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping(value="/userlogin")
	public ResponseEntity<UserDto> login(@RequestBody User user )
	{
					
		UserDto userDto =  userService.login(user.getUsername(), user.getPassword());
			
		
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);			
	}
	
}
