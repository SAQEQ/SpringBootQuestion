package com.seomantra.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.seomantra.jobportal.entity.JobPortalMail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl  implements MailService{

	@Autowired
	private JavaMailSender javaMailSender;
	

	@Override
	public void sendMail(JobPortalMail jobPortalMail) throws MailException {
		
		 SimpleMailMessage mail = new SimpleMailMessage();
		 mail.setTo(jobPortalMail.getTo());
		 mail.setFrom(jobPortalMail.getFrom());
		 mail.setSubject(jobPortalMail.getSubject());
		 mail.setText(jobPortalMail.getBody());
		 
		 javaMailSender.send(mail);
	}

	@Override
	public void sendWithAttachment(JobPortalMail jobPortalMail) throws MailException, MessagingException {
		
		MimeMessage mimeMessage =  javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setTo(jobPortalMail.getTo());
		helper.setFrom(jobPortalMail.getFrom());
		helper.setSubject(jobPortalMail.getSubject());
		helper.setText(jobPortalMail.getBody());
		
		ClassPathResource classPathResource =  new ClassPathResource(jobPortalMail.getAttachment());
		helper.addAttachment(classPathResource.getFilename(), classPathResource);
		
		 javaMailSender.send(mimeMessage);
		 
	}

}
