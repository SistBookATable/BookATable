package com.test.java.model;

import java.util.Calendar;

public class User extends Member{
	
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
	private String checkStop;
	private String signIn;  
	private String signOut;
	
	public User() {
		
	}
	
	public User (String id, String pw, String name, String phoneNumber, String jumin, int noshowCount, int balance,
			String bank, String account, String checkStop, String signIn, String signOut) {
		super();
		this.userType = 1;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.jumin = jumin;
		this.noshowCount = noshowCount;
		this.balance = balance;
		this.bank = bank;
		this.account = account;
		this.checkStop = checkStop;
		this.signIn = signIn;
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

	public String getSignOut() {
		return signOut;
	}
	
	public String getSignIn() {
		return signIn;
	}

	public boolean checkid(String id) {
		return true;
	}
	
	public boolean checkSignOut(Calendar signOut) {
		return true;
	}

	@Override
	public String toString() {
		return "User [userType=" + userType + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phoneNumber="
				+ phoneNumber + ", jumin=" + jumin + ", noshowCount=" + noshowCount + ", balance=" + balance + ", bank="
				+ bank + ", account=" + account + ", checkStop=" + checkStop + ", signIn=" + signIn + ", signOut="
				+ signOut + "]";
	}

	
}
