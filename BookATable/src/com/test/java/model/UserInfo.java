package com.test.java.model;


import java.util.Calendar;

public class UserInfo {
	
	private String id;
	private String pw;
	private String name;
	private String phoneNumber;
	private int balance;
	private String account;
	private Calendar birth;
	
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

	public int getBalance() {
		return balance;
	}

	public String getAccount() {
		return account;
	}

	public Calendar getBirth() {
		return birth;
	}

	public UserInfo(String name,String id, String pw,  Calendar birth,String phoneNumber, String account, int balance) {
	
		this.name=name;
		this.id=id;
		this.pw=pw;
		this.birth=birth;
		this.phoneNumber=phoneNumber;
		this.account=account;
		this.balance=balance;
		
	}
	
	public boolean checkPw(String pw) {
		
		
		return false;
		
	}//checkPw
	public static void load() {
	
		
	
	}//load
	

}//UserInfo
