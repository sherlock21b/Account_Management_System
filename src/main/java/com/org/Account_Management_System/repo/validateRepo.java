package com.org.Account_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.Account_Management_System.dto.bankAccount;


	public interface validateRepo extends JpaRepository<bankAccount,Integer> {
	    @Query("select ba from bankAccount ba where ba.account_number=?1")
	     bankAccount validate(long account_number);
}
