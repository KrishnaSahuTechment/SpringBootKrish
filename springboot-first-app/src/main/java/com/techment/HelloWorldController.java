package com.techment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	//Get HTTP Method
	
	
	@GetMapping("/hello-World")
	public String helloWorld() 
	{
		
		return "Hello World";
	}
	
	
	//get
	//post
	//put
	//delete
	
}
