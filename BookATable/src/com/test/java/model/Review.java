package com.test.java.model;

import java.util.Calendar;

public class Review {
	
	private int reviewNumber;
	private int reservationNumber;
	private Calendar dateWritten;
	private String content;
	private double score;
	
	public Review(int reviewNumber, double score, String content, Calendar dateWritten) {
		this.reviewNumber=reviewNumber;
		this.score=score;
		this.content=content;
		this.dateWritten=dateWritten;
	}
	
	public int getReviewNumber() {
		return reviewNumber;
	}

	public int getReservationNumber() {
		return reservationNumber;
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

	public boolean checkNumber(int reviewNumber) {
		return false;
		
	}

}
