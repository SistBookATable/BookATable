package com.test.java.model;

public class Store {

	private String licenseNumber;
	private String storeName;
	private String storeTelNumber;
	private String menuCategory;
	private int score;
	private int reservedDeposit;
	private int exceptionSales;
	private int distanceFrom;
	private int reservationCount;
	private int bookmarkedCount;
	
	private String address;
	private String tablecount;
	private boolean bookmark;
	private double averageScore;
	

	public Store(String storeName, String menuCategory, String address, String tablecount, double averageScore, String parts) {
		
	}
	public String getStoreName() {
		return storeName;
	}
	public String getStoreNumber() {
		return storeTelNumber;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public String getMenuCategory() {
		return menuCategory;
	}
//	public Menu getMenuList() {
//		return menuList;
//	}
	public int getScore() {
		return score;
	}
//	public OperatingHours getOperatingHours() {
//		return operatingHours;
//	}
	public int getReservedDeposit() {
		return reservedDeposit;
	}
	public int getExceptionSales() {
		return exceptionSales;
	}
	public int getDistanceFrom() {
		return distanceFrom;
	}
	public int getReservationCount() {
		return reservationCount;
	}
	public int getBookmarkedCount() {
		return bookmarkedCount;
	}
	
	
	public boolean checkName(String storeName) {
		return true;
	}
	
	@Override
	public String toString() {
		return "Store [licenseNumber=" + licenseNumber + ", storeName=" + storeName + ", storeTelNumber="
				+ storeTelNumber + ", menuCategory=" + menuCategory + ", score=" + score + ", reservedDeposit="
				+ reservedDeposit + ", exceptionSales=" + exceptionSales + ", distanceFrom=" + distanceFrom
				+ ", reservationCount=" + reservationCount + ", bookmarkedCount=" + bookmarkedCount + ", address="
				+ address + ", tablecount=" + tablecount + ", bookmark=" + bookmark + ", averageScore=" + averageScore
				+ "]";
	}
	
	
}
