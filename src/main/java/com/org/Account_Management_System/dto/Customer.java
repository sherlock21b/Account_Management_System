package com.org.Account_Management_System.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private int Customer_id;
	private String pan;
	private String Aadhar_Number;
	private String Name;
	private String Postal_address;
	private String Email_id;
	private String DOB;
	public int getCustomer_id() {
		return Customer_id; 
	}
	public void setCustomer(int customer_id) {
		Customer_id=customer_id;
	}
	public String getAadhar_Number() {
		return Aadhar_Number;
	}
	public void setAadhar_Number(String aadhar_number) {
		Aadhar_Number = aadhar_number;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPostal_address() {
		return Postal_address;
	}
	public void setPostal_address(String postal_address) {
		Postal_address = postal_address;
	}
	public String getEmail_id() {
		return Email_id;
	}
	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dob) {
		DOB = dob;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
}
