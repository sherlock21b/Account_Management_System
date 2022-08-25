package com.org.Account_Management_System.repo;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.Account_Management_System.dto.accountTransaction;



public interface transactionsRepo extends JpaRepository<accountTransaction, Integer>{

	@Query(value="SELECT * FROM account_transaction WHERE account_number=? LIMIT 5",nativeQuery = true)
	List<accountTransaction> showTransactions(int acc);
	
	@Query(value="SELECT * FROM account_transaction b WHERE b.time BETWEEN ? AND ? AND account_number=?",nativeQuery = true)
	List<accountTransaction> getStatement(LocalDate date1,LocalDate date2,int acc);
	
	@Query(value="SELECT  SUM(amount) FROM account_transaction acc WHERE acc.time >= NOW() - INTERVAL 1 DAY and acc.account_number=? and acc.type=? and sub_type=?",nativeQuery = true)
    Double check10k(Long long1, String type, String sub_type);
	
//	@Query(value="select current_bal from bank_account where account_number=?",nativeQuery=true)
//    Double presence(Long long1);

}