package com.org.Account_Management_System.controller;

import java.math.BigInteger;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.Account_Management_System.BCrypt;
import com.org.Account_Management_System.Mail_Controller;
import com.org.Account_Management_System.Mail_dto;
import com.org.Account_Management_System.RandomString;
import com.org.Account_Management_System.dto.Customer;
import com.org.Account_Management_System.dto.User;
import com.org.Account_Management_System.service.CustomerCreationServices;
import com.org.Account_Management_System.service.UserServices;


@RestController
public class AccountController {
	@Autowired
	CustomerCreationServices service;
	
	@Autowired
	Mail_Controller mail;
	
	@Autowired
	UserServices user_service;
	 @GetMapping("/search-pan/{pan}")
	 public int findUserByPan(@PathVariable String pan) {
		 // should be only done by bank manager --- Authorization 
		 // and only logged in user Authentication
		 return service.findUserByPan(pan);
	 }
	 @PostMapping("/account-details")
	 public Customer saveCustomer(@RequestBody Customer customer) {
		 String lUUID = String.format("%06d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0,6);
		 customer.setCustomer(Integer.parseInt(lUUID));
		 String  originalPassword = RandomString.getRandomString(8);
		 String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
		 User user=new User();
		 user.setUser(Integer.parseInt(lUUID));
		 user.setPassword(generatedSecuredPasswordHash);
		 user.setRole_id(2);
		 user_service.saveUser(user);
		 Mail_dto mailObject=new Mail_dto();
		 mailObject.setReciepent(customer.getEmail_id());
		 mailObject.setSub("Welcome to the Bank");
		 mailObject.setMsg("Here are the creditianls\n"+"Login Id: "+ customer.getCustomer_id()+"\n"+"Temp Password: "+ originalPassword);
		 mail.sendSimpleEmail(mailObject);
		 return service.saveCustomer(customer);
	}


}
