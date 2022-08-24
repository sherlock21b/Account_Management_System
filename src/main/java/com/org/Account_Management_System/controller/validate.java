package com.org.Account_Management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.org.Account_Management_System.dto.BankAccount;
import com.org.Account_Management_System.service.validate_service;
@RestController
public class validate {
	@Autowired
	validate_service service;
	
	@GetMapping("/validateaccount/{account_number}")
    public BankAccount transfer_amount(@PathVariable long account_number ) {

        BankAccount ba=null;
        ba=service.validate(account_number);

        if(ba==null){
            System.out.println("**Not Available");
            return null;
        }
        else {
            System.out.println("**Available**");
            return ba;
        }
    }
}
