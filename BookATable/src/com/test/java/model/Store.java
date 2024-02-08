package com.test.java.model;

import com.test.java.controller.FindByNameController;
import com.test.java.repository.Data;

public class Store {

	private String licenseNumber;
	private String storeName;
	private String storeTelNumber;
	private String menuCategory;
	private String address;
	private double score;
	private int distanceFrom;
	private int reviewCount;

	private String menuName;

	private String tablecount;
	private boolean bookmark;
	private double averageScore;

	/*
	 * public Store(String licenseNumber, String storeName, String storeTelNumber,
	 * String menuCategory, String address, double averageScore, int distanceFrom) {
	 * 
	 * /* public Store(String licenseNumber, String storeName, String
	 * storeTelNumber, String address) { super(); this.licenseNumber =
	 * licenseNumber; this.storeName = storeName; this.storeTelNumber =
	 * storeTelNumber; this.address = address;
	 * 
	 * // TODO distanceFrom 주소 사용해서 구하기 this.score = 0 ; this.menuCategory = null;
	 * this.distanceFrom = 0;
	 * 
	 * }
	 * 
	 * public Store(String licenseNumber, String storeName, String storeTelNumber,
	 * String address, String menuCategory) { super(); this.licenseNumber =
	 * licenseNumber; this.storeName = storeName; this.storeTelNumber =
	 * storeTelNumber; this.address = address; this.menuCategory = menuCategory;
	 * 
	 * // TODO distanceFrom 주소 사용해서 구하기 this.score = 0; this.distanceFrom = 0; }
	 * 
	 * }
	 */

	public String getAddress() {
		return address;
	}

	public String getTablecount() {
		return tablecount;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public Store(String licenseNumber, String storeName, String storeTelNumber, String menuCategory, String address,
			double score, int reviewCount) {
		this.licenseNumber = licenseNumber;
		this.storeName = storeName;
		this.storeTelNumber = storeTelNumber;
		this.menuCategory = menuCategory;
		this.address = address;
		this.score = score;
		this.distanceFrom = distanceFrom;
		this.reviewCount = reviewCount;
		// this.distanceFrom = distanceFrom;
	}

//      return sum/count;
//   }

	public String getStoreName() {
		return storeName;
	}

	public String getmenuName() {
		return menuName;
	}

	public String getStoreTelNumber() {
		return storeTelNumber;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getMenuCategory() {
		return menuCategory;
	}

//   public Menu getMenuList() {
//      return menuList;
//   }
//   public OperatingHours getOperatingHours() {
//      return operatingHours;
//   }
	public int getDistanceFrom() {
		return distanceFrom;
	}

	public boolean checkName(String storeName) {
		return true;
	}

	public int getReviewCount() {
		int count = 0;
		for(Review r : Data.reviewList) {
			if(r.getLicenseNumber().equals(this.licenseNumber)) {
				count++;
			}
		}
		return count;
	}

	public Store(String licenseNumber, String storeName, String storeTelNumber, String address, String menuCategory) {
		super();
		this.licenseNumber = licenseNumber;
		this.storeName = storeName;
		this.storeTelNumber = storeTelNumber;
		this.address = address;
		this.menuCategory = menuCategory;

		// TODO distanceFrom 주소 사용해서 구하기
		this.score = score;
		this.distanceFrom = 0;
	}

	public double getScore() {
		double sum = 0;
		int count = 0;
		for (Review r : Data.reviewList) {
			if (r.getLicenseNumber().equals(this.licenseNumber)) {
				sum += r.getScore();
				count++;
			}
		}
		if(count == 0) {
			return 0.0;
		}

		return sum / count;
	}


	@Override
	public String toString() {
		return "Store [licenseNumber=" + licenseNumber + ", storeName=" + storeName + ", storeTelNumber="
				+ storeTelNumber + ", menuCategory=" + menuCategory + ", address=" + address + ", score=" + score
				+ ", distanceFrom=" + distanceFrom + "]";
	}

	public void setBookmark(boolean bookmark) {
		this.bookmark = bookmark;
	}

	public boolean isBookmark() {
		// TODO Auto-generated method stub
		return this.bookmark;
	}
}
	