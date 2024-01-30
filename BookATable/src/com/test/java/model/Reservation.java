package com.test.java.model;

import java.util.Calendar;

public class Reservation {
	
	private int reservationNumber;
	private String userId;
	private String licenseNumber;
	private Calendar reservationTime;
	private Calendar reservationDate;
	private int numOfPeople;
	private int tableCapacity;
	
	public Reservation(int reservationNumber, Calendar reservationDate, Calendar reservationTime, int numOfPeople, int tableCapacity, String userId,String licenseNumber) {
		
		this.reservationDate=reservationDate;
		this.userId=userId;
		this.licenseNumber=licenseNumber;
		this.reservationTime=reservationTime;
		this.numOfPeople=numOfPeople;
		this.tableCapacity=tableCapacity;
		this.reservationNumber=reservationNumber;
	}
	
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
	
	public boolean checkId(String userId) {
		return false;
	}

}
