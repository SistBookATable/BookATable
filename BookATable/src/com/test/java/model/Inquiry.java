package com.test.java.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Inquiry {
	
	private String userId;
	private String title;
	private String content;
	private String adminId;
	private String type;
	private Calendar dateWritten;
	private String answer;
	
	public Inquiry(String userId, String title, String content, String adminId, String type, Calendar dateWritten, String answer) {
		this.userId=userId;
		this.title=title;
		this.content=content;
		this.adminId=adminId;
		this.type=type;
		this.dateWritten=dateWritten;
		this.answer=answer;
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

	public Calendar getDateWritten() {
		return dateWritten;
	}

	public String getAnswer() {
		return answer;
	}
	
	

	public boolean checkId(String userId) {
		return false;
	}
	
	public boolean checkNumber(int inquiryNumber) {
		return false;
	}
	
	public boolean setAnswer() {
		return false;
	}

}
