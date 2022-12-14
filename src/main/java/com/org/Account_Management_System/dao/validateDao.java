package com.org.Account_Management_System.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.Account_Management_System.dto.BankAccount;
import com.org.Account_Management_System.repo.validateRepo;


@Repository
public class validateDao {
	@Autowired
	validateRepo repo;
	public BankAccount validate(long account_number) {
	       return repo.validate(account_number);
	  }
}
