package com.seomantra.jobportal.service;

import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.seomantra.jobportal.entity.JobPortalMail;

import jakarta.mail.MessagingException;

@Service
public interface MailService {

	public void sendMail(JobPortalMail jobPortalMail);
	
	public void sendWithAttachment(JobPortalMail jobPortalMail) throws MailException, MessagingException;
	 
}
