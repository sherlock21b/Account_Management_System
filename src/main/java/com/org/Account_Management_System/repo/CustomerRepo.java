package com.org.Account_Management_System.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.Account_Management_System.dto.Customer;

import java.util.Optional;


public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	Optional<Customer> getByPan(String pan);

	@Query(value="SELECT Email_id from customer where Customer_id=?",nativeQuery=true)
    String findEmailByCustomerId(int id);
	
	@Query(value="select email_id from customer where Customer_id=(select customer_id from bank_account where account_number=?)",nativeQuery=true)
	String findEmailByAccountNumber(Long account_number);
}

