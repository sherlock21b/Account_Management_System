package com.org.Account_Management_System.controller;
import org.springframework.web.bind.annotation.RestController;


import com.org.Account_Management_System.BCrypt;
import com.org.Account_Management_System.dto.User;
import com.org.Account_Management_System.repo.userRepo;
import com.org.Account_Management_System.service.userServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class userController {
	@Autowired
	userServices account_service;
		@PutMapping("reset-password")
		public String updatePassword(@RequestBody User user) {
			String password=user.getPassword();
			String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
			user.setPassword(generatedSecuredPasswordHash);
			User u=account_service.updatePassword(user);
			if (u.getPassword()==generatedSecuredPasswordHash) {
				return "Done Successfully";
			} else {
				return "Error while saving";
			}
		}
		
		@Autowired
		userRepo userrepo;
		

			
		@PostMapping("/mngr-login")
		public ResponseEntity<String> managerLogin(@RequestBody User data) throws Exception{
			try {
				account_service.validateLogin(data, 1);
				return new ResponseEntity<String>("Success", HttpStatus.OK);
			} catch(Exception e) {
				return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
			}	
		}
		
		@PostMapping("/login")
		public ResponseEntity<Object> customerLogin(@RequestBody User data) throws Exception{
			try {
				account_service.validateLogin(data, 2);
				Map<String, Object> out = new HashMap<>();
				out.put("customer_id", data.getUser());
				//Customer Details
				String customer_name = userrepo.getCustomerNameById(data.getUser());
				out.put("customer_name", customer_name);
				//Account Details
				List<Object[]> account_details_obj = userrepo.getAccountDetailsById(data.getUser());
				List<HashMap<String, Object>> account_details = new ArrayList<HashMap<String, Object>>();
				for(int i=0; i<account_details_obj.size(); i++) {
					Object[] account_details_row = account_details_obj.get(i);
					account_details.add(
								new HashMap<String, Object>() {{
									put("account_number", account_details_row[0]);
									put("customer_id", account_details_row[1]);
									put("current_bal", account_details_row[2]);
									put("account_type", account_details_row[3]);
								}}
							);
				}
				out.put("accounts", account_details);
				return new ResponseEntity<Object>(out, HttpStatus.OK);
			} catch(Exception e) {
				return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
			}	
		}
}
