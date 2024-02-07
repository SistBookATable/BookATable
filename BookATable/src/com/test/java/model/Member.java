package com.test.java.model;

public abstract class Member {
	
	public static int level;
	public static String id;
	public abstract int getUserType();
	public abstract String toString();
	public abstract String getName();
	public abstract String getPhoneNumber();
	public abstract String getId();
	public abstract String getPw();
	public abstract String getSignIn();
	public abstract String getAccount();
	public abstract String getSignOut();
	public abstract void print();
	public abstract void printSignIn();
	public abstract int getReservationCount();
	public abstract int getNoshowCount();
}