package com.org.Account_Management_System.Controller;

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

import com.org.Account_Management_System.dto.account_transaction;
import com.org.Account_Management_System.service.Transactions_service;


@RestController
public class Transactions_Controller {
	@Autowired
	Transactions_service service;
	
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
	    public account_transaction transfer_amount(@RequestBody account_transaction ba) {
	    try
	    {
		 	ba.setType("Debit");
		 	ba.setTime(LocalDateTime.now());
		 	ba.setSub_type("Transfer");
		 	String lUUID = String.format("%06d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0,5);
			ba.setTransaction_id(Integer.parseInt(lUUID));
			return service.transfer_amount(ba);
	    }
	    	catch(Exception e)
		    {
		    	System.out.println("Transfer Amount Not Valid");
		    	return null;
		    }
	 }

}
