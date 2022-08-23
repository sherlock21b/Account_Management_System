package com.org.Account_Management_System.controller;

import java.math.BigInteger;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.Account_Management_System.dto.BankAccount;
import com.org.Account_Management_System.service.BankAccountService;

@RestController
public class BankAccountController {
	@Autowired
	BankAccountService account_service;
		@PostMapping("/account-type")
		public BankAccount saveBankAccount(@RequestBody BankAccount account) {
			String lUUID = String.format("%06d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0,9);
			account.setAccount_number(Integer.parseInt(lUUID));
			return account_service.saveAccount(account);
		}
}
