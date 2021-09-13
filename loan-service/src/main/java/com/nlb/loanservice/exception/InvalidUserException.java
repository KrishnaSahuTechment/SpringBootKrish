package com.nlb.loanservice.exception;

public class InvalidUserException extends RuntimeException {

	
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public InvalidUserException(String msg) {
		super();
		this.msg = msg;
	}

	public InvalidUserException() {
		super();
	}
	
	
	
}
