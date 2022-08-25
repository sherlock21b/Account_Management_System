package com.org.Account_Management_System.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.Account_Management_System.dto.User;
import com.org.Account_Management_System.repo.userRepo;

@Repository
public class userDao {
	@Autowired
	userRepo repo;
	public User saveUser(User user) {
		return repo.save(user);
	}
	public User updatePassword(User user) {
		return repo.save(user);
	}
	
}
