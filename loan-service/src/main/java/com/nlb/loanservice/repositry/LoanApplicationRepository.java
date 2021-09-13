package com.nlb.loanservice.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlb.loanservice.entity.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Integer> {

}
