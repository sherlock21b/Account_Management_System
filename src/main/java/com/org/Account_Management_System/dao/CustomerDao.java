package com.org.Account_Management_System.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.org.Account_Management_System.dto.Customer;
import com.org.Account_Management_System.dto.User;
import com.org.Account_Management_System.repo.CustomerRepo;

@Repository
public class CustomerDao {
	 @Autowired
	 CustomerRepo repo;
	 public int findUserByPan(String pan) {
		 Optional<Customer> user = repo.getByPan(pan);
		 if(user.isPresent())
			 return user.get().getCustomer_id();
		 else
			 return -1;
	 }
	 public Customer saveCustomer(Customer customer) {
		 return repo.save(customer);
	 }

}

