package com.test.java.model;

public class BlackList {
	private String licenseNumber;
	private String UserId;
	private int noShowCount;
	
	public BlackList(String licenseNumber, String userId, int noShowCount) {
		super();
		this.licenseNumber = licenseNumber;
		UserId = userId;
		this.noShowCount = noShowCount;
	}
	
	public void getLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public void getUserId(String UserId) {
		this.UserId = UserId;
	}
	public void getNoShowCount(int noShowCount) {
		this.noShowCount = noShowCount;
	}
	
	@Override
	public String toString() {
		return "BlackList [licenseNumber=" + licenseNumber + ", UserId=" + UserId + ", noShowCount=" + noShowCount
				+ "]";
	}
	
}
