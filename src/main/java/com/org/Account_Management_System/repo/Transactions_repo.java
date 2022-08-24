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
	
	@Query(value="SELECT  SUM(current_bal) FROM account_transaction acc WHERE acc.time >= NOW() - INTERVAL 1 DAY and acc.account_number=? and acc.type=? and sub_type=?",nativeQuery = true)
	Double check_10k(int acc, String type, String sub_type);
	
	@Query(value="select current_bal from bank_account where account_number=?",nativeQuery=true)
	double presence(int acc);
	
	@Query(value="select customer_id from bank_account where account_number=?",nativeQuery=true)
	Integer findCustomer(int acc);
	
}
