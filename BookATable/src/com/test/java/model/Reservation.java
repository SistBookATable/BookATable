package com.test.java.model;


import java.util.Calendar;

public class Reservation {
	
	private int reservationNumber;
	private String userId;
	private String licenseNumber;
	private String reservationTime;
	private String reservationDate;
	private int numOfPeple;
	private int tableCapacity;
	private String state;
	
	
	public int getReservationNumber() {
		return reservationNumber;
	}
	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public int getNumOfPeple() {
		return numOfPeple;
	}
	public void setNumOfPeple(int numOfPeple) {
		this.numOfPeple = numOfPeple;
	}
	public int getTableCapacity() {
		return tableCapacity;
	}
	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}
	@Override
	public String toString() {
		return "Reservation [reservationNumber=" + reservationNumber + ", userId=" + userId + ", licenseNumber="
				+ licenseNumber + ", reservationTime=" + reservationTime + ", reservationDate=" + reservationDate
				+ ", numOfPeple=" + numOfPeple + ", tableCapacity=" + tableCapacity + ", state=" + state + "]";
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	
	

	
	
}