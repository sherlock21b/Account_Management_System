package com.org.Account_Management_System.dao;

import java.math.BigInteger;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.org.Account_Management_System.dto.Customer;
import com.org.Account_Management_System.repo.customerRepo;

@Repository
public class customerDao {
	 @Autowired
	 customerRepo repo;
	 public int findUserByPan(String pan) {
		 Optional<Customer> user = repo.getByPan(pan);
		 if(user.isPresent())
			 return user.get().getCustomer_id();
		 else
			 return -1;
	 }
	 public Customer saveCustomer(Customer customer) {
		 String lUUID = String.format("%06d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0,6);
		 customer.setCustomer(Integer.parseInt(lUUID));
		 return repo.save(customer);
	 }

}

