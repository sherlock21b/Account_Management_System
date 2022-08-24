package com.org.Account_Management_System.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.Account_Management_System.dto.account_transaction;
import com.org.Account_Management_System.repo.AMSRepo;

@Repository
public class AMSDao {
  @Autowired
  AMSRepo repo;
  
  public account_transaction transfer_amount(account_transaction ba) {
	  	return repo.save(ba);
  }
}

/* public int findUserByPan(String pan) {
         Optional<Customer> user = repo.getByPan(pan);
         if(user.isPresent())
             return user.get().getCustomer_id();
         else
             return -1;
     } */

/*

package com.org.springbootuser.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.springbootuser.dto.User;
import com.org.springbootuser.repo.UserRepo;

@Repository
public class UserDao {
	 @Autowired
	 UserRepo repo;
	 
	 
	 public User saveUser(User user) {
		 return repo.save(user);
	 }
	 
	 public List<User> FindAllUsers() {
		 return repo.findAll();
	 }
	 
	 public User findUserByID(int id) {
		 Optional<User> user = repo.findById(id);
		 if(user.isPresent())
			 return user.get();
		 else
			 return null;
	 }
	 
	 
	 public String deleteUser(int id) {
		 User user=findUserByID(id);
		 if(user!=null) {
			 repo.delete(user);
			 return "user deleted";
		 }
		 else {
			 return "user not found";
		 }
	 }
	 
	 public User updateUser(User user) {
		 return repo.save(user);
	 }
	 
	 public List<User> findUserByName(String name) {
		 return repo.getByName(name);
	 }
	 
	 public List<User> findUserByMail(String mail) {
		 return repo.getByEmail(mail);
	 }
	 
	 public List<User> validateUser(String email, String password){
		 return repo.validateUser(email, password);
	 }
}
*/