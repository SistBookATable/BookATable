package com.test.java.model;

import java.util.Calendar;

public class Review {

	private String userId;
	private String licenseNumber;
	private int reviewNumber;
	private Calendar dateWritten;
	private String content;
	private double score;
	private int reservationNumber;
	
	
	public String getUserId() {
		return userId;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public int getReviewNumber() {
		return reviewNumber;
	}
	public Calendar getDateWritten() {
		return dateWritten;
	}
	public String getContent() {
		return content;
	}
	public double getScore() {
		return score;
	}
	public int getReservationNumber() {
		return reservationNumber;
	}
	
	
	
	
}
