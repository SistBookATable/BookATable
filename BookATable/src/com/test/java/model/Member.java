package com.test.java.model;

public abstract class Member {
	
	public static int level;
	public abstract int getUserType();
	public abstract String toString();

	public abstract String getName();
	public abstract String getPhoneNumber();
	public abstract String getId();
	public abstract String getPw();
	public abstract String getSignIn();

}