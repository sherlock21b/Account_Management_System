package com.org.Account_Management_System.dto;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transactions {
	@Id
	private int account_number;
	private String transaction_id;
	private LocalDateTime time;
	private String type;
	private String sub_type;
	private Double current_bal;
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubtype() {
		return sub_type;
	}
	public void setSubtype(String subtype) {
		this.sub_type = subtype;
	}
	public Double getCurrent_bal() {
		return current_bal;
	}
	public void setCurrent_bal(Double current_bal) {
		this.current_bal = current_bal;
	}


}
