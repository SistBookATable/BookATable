package com.test.java.model;

import java.util.Calendar;

public class Reservation {
	
	private int reservationNumber;
	private String userId;
	private String licenseNumber;
	private Calendar reservationTime;
	private Calendar reservationDate;
	private int numOfPeple;
	private int tableCapacity;
//	private State state;

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
	public int getNumOfPeple() {
		return numOfPeple;
	}
	public int getTableCapacity() {
		return tableCapacity;
	}
//	public State getState() {
//		return state;
//	}
	
	public boolean checkId(String id) {
		return true;
	}
	

}
