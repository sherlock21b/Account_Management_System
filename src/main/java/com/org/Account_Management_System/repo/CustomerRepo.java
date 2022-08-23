package com.org.Account_Management_System.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.org.Account_Management_System.dto.Customer;

import java.util.Optional;


public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	Optional<Customer> getByPan(String pan);

	
}

