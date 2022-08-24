package com.org.Account_Management_System.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.Account_Management_System.dto.Customer;

import java.util.Optional;


public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	Optional<Customer> getByPan(String pan);
	
	@Query(value="SELECT Email_id from customer where Customer_id=?",nativeQuery=true)
	String findEmail(int acc);


	
}

