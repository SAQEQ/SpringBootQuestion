package com.seomantra.jobportal.controller;

import java.util.logging.Logger;

import org.hibernate.validator.internal.util.logging.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seomantra.jobportal.entity.JobPortalMail;
import com.seomantra.jobportal.service.MailService;

import jakarta.mail.MessagingException;


@RestController

public class MailController {

	@Autowired
	private MailService mailService;
	
	@PostMapping(value="/send-mail")
	public String send(@RequestBody JobPortalMail jobPortalMail ) {
		   System.out.println("email:" + jobPortalMail.toString());
		try { 
			mailService.sendMail(jobPortalMail);
			return "Mail Send Successfully";
		} catch (MailException mailException ) {
			System.out.println(mailException);
			return mailException.toString();
		}
	}
	
	@PostMapping(value="/send-attached-mail")
	public String sendWithAttachment(@RequestBody JobPortalMail jobPortalMail) throws MessagingException {
		try {
			mailService.sendWithAttachment(jobPortalMail);
			return "Mail send With Attachment";
		} catch (MailException mailException) {
			System.out.println(mailException);
			return mailException.toString();
		}
	}
}
