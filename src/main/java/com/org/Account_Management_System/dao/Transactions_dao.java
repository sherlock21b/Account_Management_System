package com.org.Account_Management_System.dao;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.Account_Management_System.Mail_Controller;
import com.org.Account_Management_System.Mail_dto;
import com.org.Account_Management_System.dto.account_transaction;
import com.org.Account_Management_System.repo.CustomerRepo;
import com.org.Account_Management_System.repo.Transactions_repo;
import com.org.Account_Management_System.service.Transactions_service;

@Repository
public class Transactions_dao {
	@Autowired
	Transactions_repo repo;
	
	@Autowired 
	CustomerRepo customerRepo;
	@Autowired
	Mail_Controller mail;

	public List<account_transaction> showTransactions(int acc){
		return repo.showTransactions(acc);
	}
	
	public List<account_transaction> get_statement(LocalDate date1,LocalDate date2,int acc){
		return repo.get_statement(date1, date2, acc);
	}
	public account_transaction transfer_amount(account_transaction ba) {
	  	return repo.save(ba);
  }
	public account_transaction save_transactions(account_transaction tran) {
      Double check=repo.check_10k(tran.getAccount_number(),"Debit", "Cash");
      if(check==null||check<10000) {
        String email=customerRepo.findEmailByAccountNumber(tran.getAccount_number());;
		Mail_dto mailObject=new Mail_dto();
		 mailObject.setReciepent(email);
		 mailObject.setSub("Cash Transaction Info ");
		 mailObject.setMsg("Here are the Cash Transaction Detials for Account Number: "+ tran.getAccount_number()+" of Amount "+tran.getAmount()+ " is "+tran.getType() +" with the tansaction id as :"+ tran.getTransaction_id());
		 mail.sendSimpleEmail(mailObject);
          return repo.save(tran);
      }
      else {
          return null;
      }

  }


}
