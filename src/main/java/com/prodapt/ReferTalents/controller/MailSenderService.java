package com.prodapt.ReferTalents.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
	
	@Autowired
//	@Qualifier("emailconfig")
	JavaMailSender mailSender;

	public void sendEmployeeMessage(EmailProperties emailProperties) throws MessagingException, IOException {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(emailProperties.getTo());
		message.setSubject(emailProperties.getSubject());
		message.setFrom(emailProperties.getFrom());
		message.setText(emailProperties.getBody());
		mailSender.send(message);
	}

}
