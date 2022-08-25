package com.org.Account_Management_System.controller;

import java.math.BigInteger;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.org.Account_Management_System.BCrypt;
import com.org.Account_Management_System.mailController;
import com.org.Account_Management_System.mailDto;
import com.org.Account_Management_System.randomString;
import com.org.Account_Management_System.dto.Customer;
import com.org.Account_Management_System.dto.User;
import com.org.Account_Management_System.service.customerCreationServices;
import com.org.Account_Management_System.service.userServices;

import java.io.File;

@RestController
public class accountController {
	@Autowired
	customerCreationServices service;
	
	@Autowired
	mailController mail;
	
	@Autowired
	userServices user_service;
	 @GetMapping("/search-pan/{pan}")
	 public int findUserByPan(@PathVariable String pan) {
		 // should be only done by bank manager --- Authorization 
		 // and only logged in user Authentication
		 return service.findUserByPan(pan);
	 }
	 @PostMapping("/account-details")
	 public Customer saveCustomer(@RequestBody Customer customer) {
		 //move to service
		 String lUUID = String.format("%06d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0,6);
		 customer.setCustomer(Integer.parseInt(lUUID));
		 String  originalPassword = randomString.getRandomString(8);
		 String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
		 User user=new User();
		 user.setUser(Integer.parseInt(lUUID));
		 user.setPassword(generatedSecuredPasswordHash);
		 user.setRole_id(2);
		 user_service.saveUser(user);
		 mailDto mailObject=new mailDto();
		 mailObject.setReciepent(customer.getEmail_id());
		 mailObject.setSub("Welcome to the Bank");
		 mailObject.setMsg("Here are the creditianls\n"+"Login Id: "+ customer.getCustomer_id()+"\n"+"Temp Password: "+ originalPassword);
		 mail.sendSimpleEmail(mailObject);
		 //till here
		 return service.saveCustomer(customer);
	}
	  @PostMapping("/upload") 
	  public ResponseEntity<?> handleFileUpload( @RequestParam("file") MultipartFile file ) {

	    String fileName = file.getOriginalFilename();
	    System.out.println(fileName);
	    try {
	      file.transferTo( new File("C:\\upload\\" + fileName));
	    } catch (Exception e) {
	    	System.out.println(e);
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    } 
	    System.out.println(fileName);
	    return ResponseEntity.ok("File uploaded successfully.");
	  }

}
