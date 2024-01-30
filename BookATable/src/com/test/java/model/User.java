package com.test.java.model;

import java.util.Calendar;

public class User {
	
	private String id; 
	private String pw; 
	private String name; 
	private String phoneNumber;
	private Calendar birth;
	private int noshowCount;
	private int balance;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Calendar getBirth() {
		return birth;
	}

	public int getNoshowCount() {
		return noshowCount;
	}

	public int getBalance() {
		return balance;
	}

	public String getAccount() {
		return account;
	}

	public Calendar getSignOut() {
		return signOut;
	}

	public boolean checkid(String id) {
		return true;
	}
	
	public boolean checkSignOut(Calendar signOut) {
		return true;
	}
	
}
