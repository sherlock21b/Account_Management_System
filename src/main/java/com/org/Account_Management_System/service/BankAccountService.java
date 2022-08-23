package com.org.Account_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Account_Management_System.dao.BankAccountdao;
import com.org.Account_Management_System.dto.BankAccount;

@Service
public class BankAccountService {

	@Autowired
	BankAccountdao dao;
	
	public BankAccount saveAccount(BankAccount account) {
		return dao.saveAccount(account);
	}

}
