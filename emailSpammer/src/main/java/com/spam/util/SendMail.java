package com.spam.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service("mailService")
public class SendMail {
   @Autowired
   private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

   /*
    * This method will send compose and send the message
    */
   public void sendMail(String to, String subject, String body) {
	   
	  // Mail is created using MimeMessage library
	  MimeMessage message = mailSender.createMimeMessage();
	  
	  try{
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
				
			helper.setFrom("teamlilatunnit@gmail.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
			
	   }catch (MessagingException e) {
		   
			  throw new MailParseException(e);
	   }
	  
	   //sends the message
       mailSender.send(message);
    
   }
}