package com.test.java.model;

public class BlackList {
	private String licenseNumber;
	private String UserId;
	
	public BlackList(String licenseNumber, String userId) {
		super();
		this.licenseNumber = licenseNumber;
		this.UserId = userId;
	}
	
	
	public String getLicenseNumber() {
		return licenseNumber;
	}


	public String getUserId() {
		return UserId;
	}


	@Override
	public String toString() {
		return "BlackList [licenseNumber=" + licenseNumber + ", UserId=" + UserId + "]";
	}
	
}
