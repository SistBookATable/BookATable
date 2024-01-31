package com.test.java.model;

import java.util.Calendar;

public class User {
	private String id;
	private String pw;
	private String name;
	private String phoneNumber;
	private Calendar birth;
	private int noshowCount;
	private int reservationCount;
	private int balance;
	private String account;
	private Calendar signOut;

	public boolean checkId(String id) {
		return false;

	}

	public boolean checkSignOut(Calendar signOut) {

		return false;
	}
}
