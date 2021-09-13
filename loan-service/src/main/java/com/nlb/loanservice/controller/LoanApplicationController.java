package com.nlb.loanservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlb.loanservice.entity.LoanApplication;
import com.nlb.loanservice.service.ILoanApplicationService;
import com.nlb.loanservice.service.IUserService;


@RestController
@RequestMapping(value =  "api/v1")
public class LoanApplicationController {

	@Autowired
	ILoanApplicationService iLoanApplicationService;
	
	@Autowired
	IUserService userService;
	

	
	@PostMapping("/applyloan")
	public ResponseEntity <LoanApplication> saveLoanApplicationToDb(@RequestBody LoanApplication loanApplication,@RequestHeader String token ) {
		
		iLoanApplicationService.saveLoanApplication(loanApplication,token);
		
		return new ResponseEntity<LoanApplication>(loanApplication,HttpStatus.CREATED);		
	}
	
	
	@PutMapping("/approveloan/{loanId}")
	public ResponseEntity <LoanApplication> approveLoanApplicationToDb(@RequestBody LoanApplication loanApplication,@PathVariable int loanId ) {
		
		iLoanApplicationService.approveLoanApplication(loanId);
		
		return new ResponseEntity<LoanApplication>(loanApplication,HttpStatus.ACCEPTED);		
	}
	
	
	@PutMapping("/rejectloan/{loanId}")
	public ResponseEntity <LoanApplication> rejectLoanApplicationToDb(@RequestBody LoanApplication loanApplication,@PathVariable int loanId ) {
		
		iLoanApplicationService.rejectLoanApplication(loanId);
		
		return new ResponseEntity<LoanApplication>(loanApplication,HttpStatus.OK);		
	}
	
}

