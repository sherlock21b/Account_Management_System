package com.org.Account_Management_System;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class Mail_service {

	@Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(Mail_dto dto) {
        SimpleMailMessage message = new SimpleMailMessage();
//        System.out.println(dto.reciepent+" recepient"+dto.Msg+" msg"+dto.sub+" sub");
        message.setFrom("banerjeeritik@gmail.com");
        message.setTo(dto.reciepent);
        message.setText(dto.Msg);
        message.setSubject(dto.sub);
        mailSender.send(message);
        System.out.println("Mail Send...");
        


    }
}
