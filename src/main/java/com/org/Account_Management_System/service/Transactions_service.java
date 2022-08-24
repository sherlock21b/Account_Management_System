package com.org.Account_Management_System.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Account_Management_System.dto.account_transaction;
import com.org.Account_Management_System.dao.Transactions_dao;

@Service
public class Transactions_service {
	@Autowired
	Transactions_dao dao;
	public List<account_transaction> showTransactions(int acc){
		return dao.showTransactions(acc);
	}
	public List<account_transaction> get_statement(LocalDate date1,LocalDate date2,int acc){
		return dao.get_statement(date1, date2, acc);
	}
	
	public account_transaction transfer_amount(account_transaction ba) {
		   return dao.transfer_amount(ba);
	   }


}
