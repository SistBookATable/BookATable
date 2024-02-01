package com.test.java.model;

import com.test.java.repository.Data;

public class Store {

	private String licenseNumber;
	private String storeName;
	private String storeTelNumber;
	private String menuCategory;
	private String address;
	private int score;
	private int distanceFrom;
	
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
	
	public double getScore() {
		double sum = 0;
		int count = 0;
		for(Review r :Data.reviewList) {
			if(r.getLicenseNumber().equals(this.licenseNumber)) {
				sum += r.getScore();
				count ++;
			}
		}
		
		return sum/count;
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
