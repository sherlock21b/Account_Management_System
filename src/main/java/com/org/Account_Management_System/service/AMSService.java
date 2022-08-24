package com.org.Account_Management_System.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Account_Management_System.dao.AMSDao;
import com.org.Account_Management_System.dto.account_transaction;


@Service
public class AMSService {
	
   @Autowired	
   AMSDao dao;
   
   public account_transaction transfer_amount(account_transaction ba) {
	   return dao.transfer_amount(ba);
   }
}

/*
package com.org.springbootuser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.springbootuser.dao.UserDao;
import com.org.springbootuser.dto.User;

@Service
public class UserService {

	@Autowired
	UserDao dao;
	
	public User saveUser(User user) {
		return dao.saveUser(user);
	}
	
	public List<User> FindAllUsers() {
		 return dao.FindAllUsers();
	 }
	
	 public User findUserByID(int id) {
		 return dao.findUserByID(id);
	 }
	 
	 public String deleteUser(int id) {
		 return dao.deleteUser(id);
	 }
	 
	 public User updateUser(User user) {
		 return dao.updateUser(user);
	 }
	 
	 public List<User> findUserByName(String name){
		 return dao.findUserByName(name);
	 }
	 

	 public List<User> findUserByMail(String mail){
		 return dao.findUserByMail(mail);
	 }
	 
	 public List<User> validateUser(String email,String password){
		 return dao.validateUser(email,password);
	 }
	  
}
*/