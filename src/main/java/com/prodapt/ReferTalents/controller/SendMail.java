package com.prodapt.ReferTalents.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("*")
public class SendMail {
	
	
	

	@Autowired
	private MailSenderService mailSenderService;
	
	@GetMapping("/sendMail")
	    public String sendMail(@RequestParam String rjEmployeeMail,@RequestParam String rjStatus) {
		EmailProperties emailProperties=new EmailProperties();
		
		emailProperties.setFrom("Survey.Notifications@prodapt.com");
		emailProperties.setTo(rjEmployeeMail);
		emailProperties.setBody(rjStatus);
		emailProperties.setSubject("test");
		try {
			mailSenderService.sendEmployeeMessage(emailProperties);
		} catch (MessagingException | IOException e) {
			
			
		}
	        return "Mail Sent Success!";
	    }
	
	

}
