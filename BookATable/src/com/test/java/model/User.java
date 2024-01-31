package com.test.java.model;

import java.util.Calendar;

public class User {
	
	private int userType = 1; //[1:일반회원,2,3]
	private String id; 
	private String pw; 
	private String name; 
	private String phoneNumber;
	private String jumin;
	private int noshowCount;
	private int balance;
	private String bank;
	private String account; 
	private Calendar signOut;
	
	public User() {
		
	}
	
	public User (String id, String pw, String name, String phoneNumber, String jumin, int noshowCount, int balance,
			String account, Calendar signOut) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.jumin = jumin;
		this.noshowCount = noshowCount;
		this.balance = balance;
		this.account = account;
		this.signOut = signOut;
	}
	
	public int getUserType() {
		return userType;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getJumin() {
		return jumin;
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
