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
	
	public Review(String userId, String licenseNumber, int reviewNumber, Calendar dateWritten, String content,
			double score, int reservationNumber) {
		super();
		this.userId = userId;
		this.licenseNumber = licenseNumber;
		this.reviewNumber = reviewNumber;
		this.dateWritten = dateWritten;
		this.content = content;
		this.score = score;
		this.reservationNumber = reservationNumber;
	}
	
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
