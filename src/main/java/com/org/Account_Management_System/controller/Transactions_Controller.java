package com.org.Account_Management_System.controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.Account_Management_System.Mail_Controller;
import com.org.Account_Management_System.Mail_dto;
import com.org.Account_Management_System.dto.account_transaction;
import com.org.Account_Management_System.repo.CustomerRepo;
import com.org.Account_Management_System.service.Transactions_service;


@RestController
public class Transactions_Controller {
	@Autowired
	Transactions_service service;
	
	@Autowired 
	CustomerRepo repo;
	@Autowired
	Mail_Controller mail;
	@GetMapping("/latest-transactions")
	public List<account_transaction> showTransactions(@RequestParam("acc") int acc){
		return service.showTransactions(acc);
	}
	
	@GetMapping("/get-statement")
	public List<account_transaction> get_statement(@RequestParam("date1") String date1,@RequestParam("date2")String date2,@RequestParam("acc")int acc){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate d1=LocalDate.parse(date1,formatter);
		LocalDate d2=LocalDate.parse(date2,formatter);
		return service.get_statement(d1, d2, acc);
	}
	

	 @PostMapping("/account-transfer")
	    public String transfer_amount(@RequestBody account_transaction ba) {
	    try
	    {
		 	ba.setType("Debit");
		 	ba.setTime(LocalDateTime.now());
		 	ba.setSub_type("Transfer");
		 	String lUUID = String.format("%06d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0,5);
			ba.setTransaction_id(Integer.parseInt(lUUID));
			String senderEmail=repo.findEmailByAccountNumber(ba.getAccount_number());
			String receiverEmail=repo.findEmailByAccountNumber(ba.getTo_account());
			service.transfer_amount(ba);
			Mail_dto mailObject=new Mail_dto();
			 mailObject.setReciepent(senderEmail);
			 mailObject.setSub("Transaction Info ");
			 mailObject.setMsg("Here are the Transaction Detials for Account Number: "+ ba.getAccount_number()+" of Amount "+ba.getAmount()+ " is Debited with the tansaction id as :"+ba.getTransaction_id());
			 mail.sendSimpleEmail(mailObject);
			 mailObject.setReciepent(receiverEmail);
			 mailObject.setSub("Transaction Info ");
			 mailObject.setMsg("Here are the Transaction Detials for Account Number: "+ ba.getTo_account()+" of Amount "+ba.getAmount()+ " is Credited with the tansaction id as :"+ba.getTransaction_id());
			 mail.sendSimpleEmail(mailObject);
			return "Successful with the Transaction id: "+ba.getTransaction_id();
			
	    }
	    	catch(Exception e)
		    {
		    	return "Transfer Amount Not Valid";
		    }
	 }
	 @PostMapping("/cash-transfer")
	    public account_transaction save_transactions(@RequestBody account_transaction tran) {
		 try {
	        String lUUID = String.format("%06d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0,6);
		 	tran.setTime(LocalDateTime.now());
		 	tran.setSub_type("Cash");
	        tran.setTransaction_id(Integer.parseInt(lUUID));
	        String email=repo.findEmailByAccountNumber(tran.getAccount_number());
			Mail_dto mailObject=new Mail_dto();
			 mailObject.setReciepent(email);
			 mailObject.setSub("Cash Transaction Info ");
			 mailObject.setMsg("Here are the Cash Transaction Detials for Account Number: "+ tran.getAccount_number()+" of Amount "+tran.getAmount()+ " is "+tran.getType() +" with the tansaction id as :"+ tran.getTransaction_id());
			 mail.sendSimpleEmail(mailObject);

	        return service.save_transactions(tran);
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	    }

}
