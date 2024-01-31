package com.test.java.model;

public class Store {

	private String storeName;
	private String storeNumber;
	private String licenseNumber;
	private String menuCategory;
//	private Menu menuList;
	private int score;
//	private OperatingHours operatingHours;
	private int reservedDeposit;
	private int exceptionSales;
	private int distanceFrom;
	private int reservationCount;
	private int bookmarkedCount;
	

	public String getStoreName() {
		return storeName;
	}
	public String getStoreNumber() {
		return storeNumber;
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
	
	
}
