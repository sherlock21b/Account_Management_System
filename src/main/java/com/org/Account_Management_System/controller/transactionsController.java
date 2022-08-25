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

import com.org.Account_Management_System.mailController;
import com.org.Account_Management_System.mailDto;
import com.org.Account_Management_System.dto.accountTransaction;
import com.org.Account_Management_System.repo.customerRepo;
import com.org.Account_Management_System.service.transactionsService;


@RestController
public class transactionsController {
	@Autowired
	transactionsService service;
	
	@Autowired 
	customerRepo repo;
	@Autowired
	mailController mail;
	@GetMapping("/latest-transactions")
	public List<accountTransaction> showTransactions(@RequestParam("acc") int acc){
		return service.showTransactions(acc);
	}
	
	@GetMapping("/get-statement")
	public List<accountTransaction> getStatement(@RequestParam("date1") String date1,@RequestParam("date2")String date2,@RequestParam("acc")int acc){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate d1=LocalDate.parse(date1,formatter);
		LocalDate d2=LocalDate.parse(date2,formatter);
		return service.getStatement(d1, d2, acc);
	}
	

	 @PostMapping("/account-transfer")
	    public String transferAmount(@RequestBody accountTransaction ba) {
	    try
	    {
		 	ba.setType("Debit");
		 	ba.setTime(LocalDateTime.now());
		 	ba.setSub_type("Transfer");
		 	String lUUID = String.format("%06d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0,5);
			ba.setTransaction_id(Integer.parseInt(lUUID));
			String senderEmail=repo.findEmailByAccountNumber(ba.getAccount_number());
			String receiverEmail=repo.findEmailByAccountNumber(ba.getTo_account());
			service.transferAmount(ba);
			mailDto mailObject=new mailDto();
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
	    public accountTransaction saveTransactions(@RequestBody accountTransaction tran) {
		 try {
	        String lUUID = String.format("%06d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0,6);
		 	tran.setTime(LocalDateTime.now());
		 	tran.setSub_type("Cash");
	        tran.setTransaction_id(Integer.parseInt(lUUID));
	        return service.saveTransactions(tran);
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	    }

}
