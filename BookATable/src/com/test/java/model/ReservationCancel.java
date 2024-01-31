package com.test.java.model;

import java.util.Calendar;

public class ReservationCancel {
	
	private int reservationNumber;
	private String userId;
	private String licenseNumber;
	private Calendar reservationTime;
	private Calendar reservationDate;
	private int numOfPeople;
	private int tableCapacity;
	private String state;
	
	
	

	
	public int getReservationNumber() {
		return reservationNumber;
	}





	public String getUserId() {
		return userId;
	}





	public String getLicenseNumber() {
		return licenseNumber;
	}





	public Calendar getReservationTime() {
		return reservationTime;
	}





	public Calendar getReservationDate() {
		return reservationDate;
	}





	public int getNumOfPeople() {
		return numOfPeople;
	}





	public int getTableCapacity() {
		return tableCapacity;
	}





	public String getState() {
		return state;
	}





	public boolean checkReservationTime(Calendar reservationTime) {
		return true;
	}
	

}
