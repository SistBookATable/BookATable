package com.test.java.model;

public class Admin extends Member{
	
	private int userType = 3; //[1,2,3: 관리자]
	private String id; 
	private String pw;
	
	public Admin(int userType, String id, String pw) {
		super();
		this.userType = userType;
		this.id = id;
		this.pw = pw;
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
	
	@Override
	public String toString() {
		return "Admin [userType=" + userType + ", id=" + id + ", pw=" + pw + "]";
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getPhoneNumber() {
		return null;
	}

	@Override
	public String getSignIn() {
		// TODO Auto-generated method stub
		return null;
	} 

}
