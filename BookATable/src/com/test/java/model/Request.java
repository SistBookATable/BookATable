package com.test.java.model;

import java.util.Calendar;

public class Request {
	private int requestNumber;
	private int reviewNumber;
	private String licenseNumber;
	private String reason;
	private String requester;
	private Calendar dateWritten;
	private String permission;
	
	public Request(int requestNumber, int reviewNumber, String licenseNumber, String reason, String requester,
			Calendar dateWritten, String permission) {
		super();
		this.requestNumber = requestNumber;
		this.reviewNumber = reviewNumber;
		this.licenseNumber = licenseNumber;
		this.reason = reason;
		this.requester = requester;
		this.dateWritten = dateWritten;
		this.permission = permission;
	}
	
	public void setPermission(String permission) {
		this.permission = permission;
	}

	public int getRequestNumber() {
		return requestNumber;
	}

	public int getReviewNumber() {
		return reviewNumber;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getReason() {
		return reason;
	}

	public String getRequester() {
		return requester;
	}

	public Calendar getDateWritten() {
		return dateWritten;
	}

	public String getPermission() {
		return permission;
	}

	
	
	
}
