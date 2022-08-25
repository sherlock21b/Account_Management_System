package com.org.Account_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.org.Account_Management_System.dto.bankAccount;
import com.org.Account_Management_System.service.validateService;
@RestController
public class validateController {
	@Autowired
	validateService service;
	
	@GetMapping("/validate-account/{account_number}")
    public String transfer_amount(@PathVariable long account_number ) {

        bankAccount ba=null;
        ba=service.validate(account_number);
        if(ba==null){
            return "Not found";
        }
        else {
            return "Account is Present";
        }
    }
}
