package com.org.Account_Management_System.controller;

import java.math.BigInteger;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.Account_Management_System.mailController;
import com.org.Account_Management_System.mailDto;
import com.org.Account_Management_System.dto.bankAccount;
import com.org.Account_Management_System.repo.customerRepo;
import com.org.Account_Management_System.service.bankAccountService;

@RestController
public class bankAccountController {
	@Autowired
	bankAccountService account_service;
	
	@Autowired
	customerRepo repo;
	
	@Autowired
	mailController mail;
		@PostMapping("/account-type")
		public bankAccount saveBankAccount(@RequestBody bankAccount account) {
			String lUUID = String.format("%06d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0,9);
			account.setAccount_number(Long.parseLong(lUUID));
			mailDto mailObject=new mailDto();
			 mailObject.setReciepent(repo.findEmailByCustomerId(account.getCustomer_id()));
			 mailObject.setSub("Your Account Details");
			 mailObject.setMsg("Here are the Account Detials for customer"+account.getCustomer_id()+"\n"+"Account Number: "+ account.getAccount_number()+"\n"+"Account Type: "+ account.getAccount_type()+"\n"+"Opening balance: "+account.getCurrent_bal());
			 mail.sendSimpleEmail(mailObject);
			return account_service.saveAccount(account);
		}
}
