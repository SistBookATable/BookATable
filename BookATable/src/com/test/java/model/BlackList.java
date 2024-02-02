package com.test.java.model;

public class BlackList {
	private String licenseNumber;
	private String UserId;
	private int noShowCount;
	
	public BlackList(String licenseNumber, String userId, int noShowCount) {
		super();
		this.licenseNumber = licenseNumber;
		this.UserId = userId;
		this.noShowCount = noShowCount;
	}
	
	
	public String getLicenseNumber() {
		return licenseNumber;
	}


	public String getUserId() {
		return UserId;
	}


	public int getNoShowCount() {
		return noShowCount;
	}


	@Override
	public String toString() {
		return "BlackList [licenseNumber=" + licenseNumber + ", UserId=" + UserId + ", noShowCount=" + noShowCount
				+ "]";
	}
	
}
