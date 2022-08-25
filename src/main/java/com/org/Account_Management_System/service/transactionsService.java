package com.org.Account_Management_System.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Account_Management_System.dto.accountTransaction;

import com.org.Account_Management_System.dao.transactionsDao;

@Service
public class transactionsService {
	@Autowired
	transactionsDao dao;
	public List<accountTransaction> showTransactions(int acc){
		return dao.showTransactions(acc);
	}
	public List<accountTransaction> getStatement(LocalDate date1,LocalDate date2,int acc){
		return dao.getStatement(date1, date2, acc);
	}
	
	public accountTransaction transferAmount(accountTransaction ba) {
		   return dao.transferAmount(ba);
	   }
	public accountTransaction saveTransactions(accountTransaction tran) {
        return dao.saveTransactions(tran);
    }

}
