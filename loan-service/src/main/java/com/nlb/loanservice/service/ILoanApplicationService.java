package com.nlb.loanservice.service;

import com.nlb.loanservice.entity.LoanApplication;

public interface ILoanApplicationService {

	LoanApplication saveLoanApplication(LoanApplication loanApplication,String token );
	LoanApplication approveLoanApplication(int loanId);
	LoanApplication  rejectLoanApplication(int loanId);
	
}
