package com.org.Account_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Account_Management_System.BCrypt;
import com.org.Account_Management_System.dao.Userdao;
import com.org.Account_Management_System.dto.User;
import com.org.Account_Management_System.repo.UserRepo;

@Service
public class UserServices {

	@Autowired
	Userdao dao;
	@Autowired
	UserRepo userrepo;
	
	public boolean validateLogin (User data, int roleid) throws Exception{
		int user_id = data.getUser();
		String password = data.getPassword();
		User user = userrepo.findByUserId(user_id);
		if (user != null && user.getRole_id() == roleid) {
			if (BCrypt.checkpw(password, user.getPassword())){
				return true;
			} else {
				throw new Exception("Invalid Credentials");
			}
		} else {
			throw new Exception("Invalid Credentials");
		}
	}
	
	public User saveUser(User user) {
		return dao.saveUser(user);
	}
	public User updatePassword(User user) {
		return dao.updatePassword(user);
	}
}

