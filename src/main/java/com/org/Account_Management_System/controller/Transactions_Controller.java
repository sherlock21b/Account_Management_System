package com.org.Account_Management_System.controller;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.Account_Management_System.Mail_dto;
import com.org.Account_Management_System.Mail_service;
import com.org.Account_Management_System.dto.Customer;
import com.org.Account_Management_System.dto.account_transaction;
import com.org.Account_Management_System.service.CustomerCreationServices;
import com.org.Account_Management_System.service.Transactions_service;


@RestController
public class Transactions_Controller {
	@Autowired
	Transactions_service service;
	Mail_dto dto=new Mail_dto();
	Mail_service mail=new Mail_service();
	Customer customer= new Customer();
	CustomerCreationServices cust =new CustomerCreationServices();
	
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
	
	 @PostMapping("/amounttransfer")
	    public account_transaction transfer_amount(@RequestBody account_transaction ba) {
		 	ba.setType("Credit");
	    	return service.transfer_amount(ba);
	    }
	 @PostMapping("/cash-transfer")
		public account_transaction save_transactions(@RequestBody account_transaction tran) {
			LocalDateTime date =LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), 
	                TimeZone.getDefault().toZoneId()); 
			String lUUID = String.format("%06d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0,6);
			
			tran.setTime(date);
			tran.setTransaction_id(Integer.parseInt(lUUID));
			int cust_id=service.findCustomer(tran.getAccount_number());
			String msg="Your Customer id is "+cust_id+" , your Transaction id is  "+ tran.getTransaction_id()+" ,your Account number is "+tran.getAccount_number()+" and the time of transaction is "+ tran.getTime();
			System.out.println(cust.findEmail(cust_id)); 
			dto.setReciepent(cust.findEmail(cust_id));
			 dto.setMsg(msg);
			 dto.setSub("Welcome to the bank");
			 System.out.println(dto.getMsg()+"  "+dto.getReciepent()+"  "+dto.getSub());
			 mail.sendSimpleEmail(dto);
			
			return service.save_transactions(tran);
		}


}
