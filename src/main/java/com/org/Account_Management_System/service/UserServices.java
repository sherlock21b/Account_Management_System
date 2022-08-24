package com.org.Account_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.org.Account_Management_System.dao.Userdao;
import com.org.Account_Management_System.dto.User;

@Service
public class UserServices {

	@Autowired
	Userdao dao;
	public User saveUser(User user) {
		return dao.saveUser(user);
	}
	public User updatePassword(User user) {
		return dao.updatePassword(user);
	}
}
