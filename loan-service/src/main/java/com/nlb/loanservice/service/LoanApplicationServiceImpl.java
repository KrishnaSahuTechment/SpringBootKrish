package com.nlb.loanservice.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlb.loanservice.dto.UserDto;
import com.nlb.loanservice.entity.LoanApplication;
import com.nlb.loanservice.entity.User;
import com.nlb.loanservice.exception.LoanApplicationAlreadyExistsException;
import com.nlb.loanservice.exception.LoanApplicationNotFoundException;
import com.nlb.loanservice.repositry.LoanApplicationRepository;


@Service
public class LoanApplicationServiceImpl implements ILoanApplicationService{

	@Autowired
	LoanApplicationRepository loanApplicationRepositry;
	
	@Autowired
	IUserService userService;
	
	@Override
	public LoanApplication saveLoanApplication (LoanApplication loanApplication,String token )  throws LoanApplicationAlreadyExistsException {
		// TODO Auto-generated method stub
	
		try
		{			
			UserDto user	=  userService.login(token);
			
						if(user.getUsername().isEmpty() || user.getPassword().isEmpty())
						{
							throw  new LoanApplicationAlreadyExistsException("UnAuthorized ");
							
						}
						else
						{
							
			
							loanApplicationRepositry.save(loanApplication);
			
							return loanApplication;
						}
			
		}catch(LoanApplicationAlreadyExistsException exception)		
		{
			
			throw  new LoanApplicationAlreadyExistsException("Loan application already exists");
		}
		
	}

	@Override
	public LoanApplication approveLoanApplication(int loanId) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
		try
		{
			LoanApplication loanApp =  loanApplicationRepositry.getById(loanId);	
			loanApp.setStatus("approved");
			
			loanApplicationRepositry.save(loanApp);
			return loanApp;
			
		}catch(NoSuchElementException exception)		
		{
			
			throw  new LoanApplicationNotFoundException("Loan application not found");
		}
		
		
	}

	@Override
	public LoanApplication rejectLoanApplication(int loanId) throws NoSuchElementException {
		// TODO Auto-generated method stub
		try
		{
			LoanApplication loanApp =  loanApplicationRepositry.getById(loanId);	
			loanApp.setStatus("rejected");
			
			loanApplicationRepositry.save(loanApp);
			return loanApp;
			
		}catch(NoSuchElementException  exception)		
		{
			
			throw  new LoanApplicationNotFoundException("Loan application not found");
		}
		
		
	}

}
