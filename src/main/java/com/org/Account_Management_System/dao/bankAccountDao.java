package com.org.Account_Management_System.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.Account_Management_System.dto.bankAccount;
import com.org.Account_Management_System.repo.accountRepo;

@Repository
public class bankAccountDao {
	 @Autowired
	 accountRepo repo;
	public bankAccount saveAccount(bankAccount account) {
		return repo.save(account);
	}

}
