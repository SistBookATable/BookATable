package com.test.java.model;

import java.util.Calendar;

public class Inquiry {
	private int inquiryNumber;
	private String userId;
	private String title;
	private String content;
	private String adminId;
	private String type;
	private String dateWritten;
	private String answer;
	
	
	
	public Inquiry(int inquiryNumber, String userId, String title, String content, String adminId, String type,
			String dateWritten, String answer) {
		super();
		this.inquiryNumber = inquiryNumber;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.adminId = adminId;
		this.type = type;
		this.dateWritten = dateWritten;
		this.answer = answer;
	}
	public int getInquiryNumber() {
		return inquiryNumber;
	}
	public String getUserId() {
		return userId;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getAdminId() {
		return adminId;
	}
	public String getType() {
		return type;
	}
	public String getDateWritten() {
		return dateWritten;
	}
	public String getAnswer() {
		return answer;
	}
	
	
}