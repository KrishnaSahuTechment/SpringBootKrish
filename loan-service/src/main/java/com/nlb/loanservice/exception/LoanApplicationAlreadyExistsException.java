package com.nlb.loanservice.exception;

public class LoanApplicationAlreadyExistsException extends RuntimeException{

	String msg;

	public LoanApplicationAlreadyExistsException() {
		super();
	}

	
	
	public LoanApplicationAlreadyExistsException(String msg) {
		super();
		this.msg = msg;
	}



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
