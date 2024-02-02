package com.test.java.model;


import java.util.ArrayList;
import java.util.Calendar;


public class Reservation {
	
	private int reservationNumber;
	private String userId;
	private String licenseNumber;
	private String reservationTime;
	private String reservationDate;
	private int numOfPeople;
	private int tableCapacity;
	private String state;
	private ArrayList<String> menulist = new ArrayList<>();
	
	
	
	public Reservation(int int1, String string, String string2, String string3, String string4, int int2, int int3,
			String string5, ArrayList<String> arr) {
		// TODO Auto-generated constructor stub
	}

	public void addmenu(String name) {
		menulist.add(name);
	}
	
	public ArrayList<String> getMenulist() {
		return menulist;
	}
	public void setMenulist(ArrayList<String> menulist) {
		this.menulist = menulist;
	}
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
	public int getNumOfPeople() {
		return numOfPeople;
	}
	public void setNumOfPeople(int numOfPeple) {
		this.numOfPeople = numOfPeple;
	}
	public int getTableCapacity() {
		return tableCapacity;
	}
	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		System.out.println(menulist);
		return "Reservation [reservationNumber=" + reservationNumber + ", userId=" + userId + ", licenseNumber="
				+ licenseNumber + ", reservationTime=" + reservationTime + ", reservationDate=" + reservationDate
				+ ", numOfPeople=" + numOfPeople + ", tableCapacity=" + tableCapacity + ", state=" + state
				+ ", menulist=" + menulist + "]";
	}

	
	
	
	
	
	
	

	
	
}