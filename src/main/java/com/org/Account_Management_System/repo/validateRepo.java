package com.org.Account_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.Account_Management_System.dto.BankAccount;


	public interface validateRepo extends JpaRepository<BankAccount,Integer> {
	    @Query("select ba from BankAccount ba where ba.account_number=?1")
	     BankAccount validate(long account_number);
}
