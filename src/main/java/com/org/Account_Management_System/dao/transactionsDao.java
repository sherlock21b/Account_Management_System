package com.org.Account_Management_System.dao;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.Account_Management_System.mailController;
import com.org.Account_Management_System.mailDto;
import com.org.Account_Management_System.dto.accountTransaction;
import com.org.Account_Management_System.repo.customerRepo;

import com.org.Account_Management_System.repo.transactionsRepo;


@Repository
public class transactionsDao {
	@Autowired
	transactionsRepo repo;
	
	@Autowired 
	customerRepo customerRepo;
	@Autowired
	mailController mail;

	public List<accountTransaction> showTransactions(int acc){
		return repo.showTransactions(acc);
	}
	
	public List<accountTransaction> getStatement(LocalDate date1,LocalDate date2,int acc){
		return repo.getStatement(date1, date2, acc);
	}
	public accountTransaction transferAmount(accountTransaction ba) {
	  	return repo.save(ba);
  }
	public accountTransaction saveTransactions(accountTransaction tran) {
      Double check=repo.check10k(tran.getAccount_number(),"Debit", "Cash");
      if(check==null||check<10000) {
        String email=customerRepo.findEmailByAccountNumber(tran.getAccount_number());;
		mailDto mailObject=new mailDto();
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
