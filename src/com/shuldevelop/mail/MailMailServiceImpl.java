package com.shuldevelop.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.transaction.annotation.Transactional;


public class MailMailServiceImpl implements MailMailService{
	
	@Autowired
	private MailSender mailSender;
	
	@Transactional
	public void sendMail(String from, String to, String subject, String msg) {  
	   
		 SimpleMailMessage message = new SimpleMailMessage();  
	     message.setFrom(from);  
	     message.setTo(to);
	     message.setSubject(subject);
	     message.setText(msg);
	       
	     mailSender.send(message);     
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
}
