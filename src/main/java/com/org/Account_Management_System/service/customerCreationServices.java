package com.org.Account_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.org.Account_Management_System.dao.customerDao;
import com.org.Account_Management_System.dto.Customer;

@Service
public class customerCreationServices {
	@Autowired
	customerDao dao;
	
	 public int findUserByPan(String pan){
		 return dao.findUserByPan(pan);
	 }
	public Customer saveCustomer(Customer customer) {
		return dao.saveCustomer(customer);
	}

}

