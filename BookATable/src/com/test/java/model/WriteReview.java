package com.test.java.model;

import java.util.Calendar;

public class WriteReview {
	
	private Calendar reservationDate;
	private String storeName;
	private int numOfPeople;
	private String state;
	
	public Calendar getReservationDate() {
		return reservationDate;
	}
	public String getStoreName() {
		return storeName;
	}
	public int getNumOfPeople() {
		return numOfPeople;
	}
	public String getState() {
		return state;
	}
	
	public boolean checkReviewCheck(int reviewCheck) {
		return true;
	}
	
	

}
