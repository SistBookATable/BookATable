package com.test.java.model;

import java.util.Calendar;

public class Inquiry {
	private String userId;
	private String title;
	private String content;
	private String adminId;
	private String type;
	private Calendar dateWritten;
	private String answer;
	
	
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
	public Calendar getDateWritten() {
		return dateWritten;
	}
	public String getAnswer() {
		return answer;
	}
	
	
}