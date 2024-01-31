package com.test.java.model;

import java.util.Calendar;

public class BusinessUser {
	
	private String id; 
	private String pw; 
	private String name; 
	private String storeName; 
	private String licenseNumber;
	private String phoneNumber;
	private String account; 
	private Calendar signOut;
	
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getStoreName() {
		return storeName;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAccount() {
		return account;
	}

	public Calendar getSignOut() {
		return signOut;
	}

	public boolean checkId(String inputId) {
		return true;
	}
	
	public boolean checkSignOut(Calendar inputSignOut) {
		return true;
	}

	
	
}
