package com.org.Account_Management_System.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.Account_Management_System.dto.BankAccount;
import com.org.Account_Management_System.repo.AccountRepo;

@Repository
public class BankAccountdao {
	 @Autowired
	 AccountRepo repo;
	public BankAccount saveAccount(BankAccount account) {
		return repo.save(account);
	}

}
