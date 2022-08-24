package com.org.Account_Management_System.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {
	@Id
	private Long account_number;
	private int customer_id;
	private double current_bal;
	private String account_type;
	
	public Long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(Long account_number) {
		this.account_number = account_number;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public double getCurrent_bal() {
		return current_bal;
	}
	public void setCurrent_bal(double current_bal) {
		this.current_bal = current_bal;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	
}
