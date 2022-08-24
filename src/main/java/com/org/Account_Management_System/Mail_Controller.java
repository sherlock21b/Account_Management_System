package com.org.Account_Management_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mail_Controller {
	@Autowired
	Mail_service service;
	@PostMapping("/send")
	public void sendSimpleEmail(@RequestBody Mail_dto dto ) {
		service.sendSimpleEmail(dto);
		System.out.println("Done");
		
	}

}
