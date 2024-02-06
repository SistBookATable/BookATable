package com.test.java.model;

import com.test.java.controller.FindGPAController;
import com.test.java.repository.Data;


public class Store {

	private String licenseNumber;
	private String storeName;
	private String storeTelNumber;
	private String menuCategory;
	private String address;
	private int score;
	private int distanceFrom;
	private int reviewCount;

	private String menuName;

	private String tablecount;
	private boolean bookmark;
	private double averageScore;
	private int reservationNumber;
	private int no;
	

	/*public Store(String licenseNumber, String storeName, String storeTelNumber, String menuCategory, String address, double averageScore, int distanceFrom) {

   /*
   public Store(String licenseNumber, String storeName, String storeTelNumber, String address) {
>>>>>>> Stashed changes
      super();
      this.licenseNumber = licenseNumber;
      this.storeName = storeName;
      this.storeTelNumber = storeTelNumber;
      this.address = address;

      // TODO distanceFrom 주소 사용해서 구하기
      this.score = 0 ;
      this.menuCategory = null;
      this.distanceFrom = 0;

   }

   public Store(String licenseNumber, String storeName, String storeTelNumber, String address, String menuCategory) {
      super();
      this.licenseNumber = licenseNumber;
      this.storeName = storeName;
      this.storeTelNumber = storeTelNumber;
      this.address = address;
      this.menuCategory = menuCategory;

      // TODO distanceFrom 주소 사용해서 구하기
      this.score = 0;
      this.distanceFrom = 0;
   }

   }*/
	//<<<<<<< Updated upstream
	
	
	public String getAddress() {
		return address;
	}

	public String getTablecount() {
		return tablecount;
	}

	public double getAverageScore() {
		return averageScore;
	}
	public Store(String licenseNumber, String storeName, String storeTelNumber, String menuCategory, String address, double score, int distanceFrom) {
		this.licenseNumber = licenseNumber;
		this.storeName = storeName;
		this.storeTelNumber = storeTelNumber;
		this.menuCategory = menuCategory;
		this.address = address;
		this.score = (int)(score);
		this.distanceFrom = distanceFrom;
		this.reviewCount = reviewCount;
		//this.distanceFrom = distanceFrom;
	}

	public double getScore() {
		//      double sum = 0;
		//      int count = 0;
		//      for(Store r :Data.storeList) {
		//         if(r.getLicenseNumber().equals(this.licenseNumber)) {
		//            sum += r.getScore();
		//            count++;
		//         }

		return this.score;
	}

	//      return sum/count;
	//   }

	public String getStoreName() {
		return storeName;
	}

	public int getReservationNumber() {
		return reservationNumber;
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



	@Override
	public String toString() {
		return "Store [licenseNumber=" + licenseNumber + ", storeName=" + storeName + ", storeTelNumber=" + storeTelNumber
				+ ", menuCategory=" + menuCategory + ", address=" + address + ", score=" + score + ", distanceFrom="
				+ distanceFrom + ", reviewCount=" + reviewCount + "]";
	}

	public int getReviewCount() {
		int reviewCount = 0;
		for(Review r : Data.reviewList) {
			if(r.getLicenseNumber().equals(this.licenseNumber)) {
				reviewCount++;
			}
		}
		return reviewCount;
	}




}