package com.org.Account_Management_System;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface Transactions_repo extends JpaRepository<Transactions, Integer>{

	@Query(value="SELECT * FROM account_transaction WHERE account_number=? LIMIT 5",nativeQuery = true)
	List<Transactions> showTransactions(int acc);
	
	@Query(value="SELECT * FROM account_transaction b WHERE b.time BETWEEN ? AND ? AND account_number=?",nativeQuery = true)
	List<Transactions> get_statement(LocalDate date1,LocalDate date2,int acc);
}
