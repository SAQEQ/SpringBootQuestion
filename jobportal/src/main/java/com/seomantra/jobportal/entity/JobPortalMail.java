package com.seomantra.jobportal.entity;

public class JobPortalMail {


	private String to;
	private String from;
	private String subject;
	private String body;
	private String attachment;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	   @Override
	    public String toString() {
	        return "JobPortalMail{" +
	                "to='" + to + '\'' +
	                ", from='" + from + '\'' +
	                ", subject='" + subject + '\'' +
	                ", body='" + body + '\'' +
	                ", attachment='" + attachment + '\'' +
	                '}';
	    }
}

