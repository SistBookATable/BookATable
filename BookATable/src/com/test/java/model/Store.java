package com.test.java.model;

public class Store {

	private String licenseNumber;
	private String storeName;
	private String storeTelNumber;
	private String menuCategory;
	private String address;
	private int score;
	private int distanceFrom;
	
	private String menuName;
	
	private String tablecount;
	private boolean bookmark;
	private double averageScore;
	


	public Store(String licenseNumber, String storeName, String storeTelNumber, String address) {
		super();
		this.licenseNumber = licenseNumber;
		this.storeName = storeName;
		this.storeTelNumber = storeTelNumber;
		this.address = address;
		
		// TODO distanceFrom 주소 사용해서 구하기
		this.score = 0;
		this.menuCategory = null;
		this.distanceFrom = 0;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public String getmenuName() {
		return menuName;
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
	public int getDistanceFrom() {
		return distanceFrom;
	}
	
	public boolean checkName(String storeName) {
		return true;
	}

	@Override
	public String toString() {
		return "Store [licenseNumber=" + licenseNumber + ", storeName=" + storeName + ", storeTelNumber="
				+ storeTelNumber + ", menuCategory=" + menuCategory + ", address=" + address + ", score=" + score
				+ ", distanceFrom=" + distanceFrom + "]";
	}
	
}
