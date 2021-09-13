package com.nlb.loanservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="loan100")
@Entity
public class LoanApplication {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanId;
	private String bankName; 
	private double minLoanAmount; 
	private double maxLoanAmount;
	private double minInterestRate; 
	private double minCreditScore; 
    private String termLength; 
	private double processingFee; 
	private double rating; 
	
	@Column(columnDefinition = "default 'pending'")
	private String Status;
	
	public LoanApplication() {
		super();
	}

	public int getId() {
		return loanId;
	}

	public void setId(int id) {
		loanId = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getMinLoanAmount() {
		return minLoanAmount;
	}

	public void setMinLoanAmount(double minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}

	public double getMaxLoanAmount() {
		return maxLoanAmount;
	}

	public void setMaxLoanAmount(double maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}

	public double getMinInterestRate() {
		return minInterestRate;
	}

	public void setMinInterestRate(double minInterestRate) {
		this.minInterestRate = minInterestRate;
	}

	public double getMinCreditScore() {
		return minCreditScore;
	}

	public void setMinCreditScore(double minCreditScore) {
		this.minCreditScore = minCreditScore;
	}

	public String getTermLength() {
		return termLength;
	}

	public void setTermLength(String termLength) {
		this.termLength = termLength;
	}

	public double getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(double processingFee) {
		this.processingFee = processingFee;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	
	
}
