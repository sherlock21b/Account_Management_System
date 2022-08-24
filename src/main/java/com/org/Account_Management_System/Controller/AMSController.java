package com.org.Account_Management_System.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.org.Account_Management_System.service.AMSService;
import com.org.Account_Management_System.dto.account_transaction;

import java.util.*;

@RestController
public class AMSController {
    @Autowired 
    AMSService service;
    
    @PostMapping("/amounttransfer")
    public account_transaction transfer_amount(@RequestBody account_transaction ba) {
    	return service.transfer_amount(ba);
    }
    
    
}


