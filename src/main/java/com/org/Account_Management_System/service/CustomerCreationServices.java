package com.org.Account_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.org.Account_Management_System.dao.CustomerDao;
import com.org.Account_Management_System.dto.Customer;

@Service
public class CustomerCreationServices {
	@Autowired
	CustomerDao dao;
	
	 public int findUserByPan(String pan){
		 return dao.findUserByPan(pan);
	 }
	public Customer saveCustomer(Customer customer) {
		return dao.saveCustomer(customer);
	}
	public String findEmail(int acc) {
		return dao.findEmail(acc);
	}

}

