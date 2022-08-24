package com.org.Account_Management_System.repo;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.Account_Management_System.dto.account_transaction;


public interface Transactions_repo extends JpaRepository<account_transaction, Integer>{

	@Query(value="SELECT * FROM account_transaction WHERE account_number=? LIMIT 5",nativeQuery = true)
	List<account_transaction> showTransactions(int acc);
	
	@Query(value="SELECT * FROM account_transaction b WHERE b.time BETWEEN ? AND ? AND account_number=?",nativeQuery = true)
	List<account_transaction> get_statement(LocalDate date1,LocalDate date2,int acc);
}
