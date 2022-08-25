package com.org.Account_Management_System.dto;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.LocalTime;
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;

@Entity
public class accountTransaction  {
	
	@Id
	private int transaction_id;
	private long to_account;
	private double amount;
	private String sub_type;
	private String type;
	private Long account_number;
	
	LocalDateTime time;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(Long account_number) {
		this.account_number = account_number;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	
	public long getTo_account() {
		return to_account;
	}
	public void setTo_account(long to_account) {
		this.to_account = to_account;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getSub_type() {
		return sub_type;
	}
	public void setSub_type(String sub_type) {
		this.sub_type = sub_type;
	}
	
}

/*import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Main {
  public static void main(String[] args) {
    LocalDateTime myDateObj = LocalDateTime.now();
    System.out.println("Before formatting: " + myDateObj);
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    String formattedDate = myDateObj.format(myFormatObj);
    System.out.println("After formatting: " + formattedDate);
  }
}*/