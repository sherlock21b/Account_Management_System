package com.org.Account_Management_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mailController {
	@Autowired
	mailService service;
	@PostMapping("/send")
	public void sendSimpleEmail(@RequestBody mailDto dto ) {
		service.sendSimpleEmail(dto);
		System.out.println("Done");
		
	}

}
