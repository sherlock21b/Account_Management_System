package com.org.Account_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Account_Management_System.dao.bankAccountDao;
import com.org.Account_Management_System.dto.bankAccount;

@Service
public class bankAccountService {

	@Autowired
	bankAccountDao dao;
	
	public bankAccount saveAccount(bankAccount account) {
		return dao.saveAccount(account);
	}

}
