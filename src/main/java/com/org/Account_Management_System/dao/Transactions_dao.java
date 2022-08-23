package com.org.Account_Management_System;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class Transactions_dao {
	@Autowired
	Transactions_repo repo;

	public List<Transactions> showTransactions(int acc){
		return repo.showTransactions(acc);
	}
	
	public List<Transactions> get_statement(LocalDate date1,LocalDate date2,int acc){
		return repo.get_statement(date1, date2, acc);
	}
}
