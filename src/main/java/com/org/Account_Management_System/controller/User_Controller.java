package com.org.Account_Management_System.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.org.Account_Management_System.BCrypt;
import com.org.Account_Management_System.dto.User;
import com.org.Account_Management_System.service.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class User_Controller {
	@Autowired
	UserServices account_service;
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
}
