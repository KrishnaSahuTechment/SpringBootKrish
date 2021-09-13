package com.nlb.loanservice.exception;

public class LoanApplicationNotFoundException extends RuntimeException{

	String msg;

	public LoanApplicationNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public LoanApplicationNotFoundException() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
