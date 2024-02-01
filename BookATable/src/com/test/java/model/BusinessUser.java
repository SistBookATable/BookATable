package com.test.java.model;

import java.util.Calendar;

public class BusinessUser extends Member{
	
	private int userType = 2;
	private String id; 
	private String pw; 
	private String name; 
	private String licenseNumber;
	private String phoneNumber;
	private String bank; 
	private String account; 
	private Calendar signOut;
	
	
	
	public BusinessUser(String id, String pw, String name, String licenseNumber, String phoneNumber, String bank,
			String account) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.phoneNumber = phoneNumber;
		this.bank = bank;
		this.account = account;
		
		this.userType = 2;
		this.signOut = null;
	}

	@Override
	public String toString() {
		return "BusinessUser [userType=" + userType + ", id=" + id + ", pw=" + pw + ", name=" + name
				+ ", licenseNumber=" + licenseNumber + ", phoneNumber=" + phoneNumber + ", bank=" + bank + ", account="
				+ account + ", signOut=" + signOut + "]";
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public int getUserType() {
		return userType;
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
