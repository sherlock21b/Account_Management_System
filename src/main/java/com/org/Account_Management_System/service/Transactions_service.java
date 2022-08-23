package com.org.Account_Management_System;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class Transactions_service {
	@Autowired
	Transactions_dao dao;
	public List<Transactions> showTransactions(int acc){
		return dao.showTransactions(acc);
	}
	public List<Transactions> get_statement(LocalDate date1,LocalDate date2,int acc){
		return dao.get_statement(date1, date2, acc);
	}

}
