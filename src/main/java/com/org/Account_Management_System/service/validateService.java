package com.org.Account_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Account_Management_System.dao.validateDao;
import com.org.Account_Management_System.dto.bankAccount;

@Service
public class validateService {
	@Autowired
	validateDao dao;
	public bankAccount validate(long account_number) {
		return dao.validate(account_number);
	   }

}
