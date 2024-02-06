package com.test.java.model;

public class Bookmark {
	private String licenseNumber;
	private String userId;
	

	public Bookmark(String licenseNumber, String userId) {
		super();
		this.licenseNumber = licenseNumber;
		this.userId = userId;
		
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}
	
	
	public String getUserId() {
		return userId;
	}

	
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	@Override
	public String toString() {
		return "Bookmark [licenseNumber=" + licenseNumber + ", userId=" + userId + "]";
	}
	
	
	
}
