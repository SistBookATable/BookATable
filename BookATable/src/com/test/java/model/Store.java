package com.test.java.model;

import com.test.java.repository.Data;

/**
 * 매장의 정보를 가지고 있는 Store 클래스
 * 
 */

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

	public String getAddress() {
		return address;
	}

	public String getTablecount() {
		return tablecount;
	}

	public double getAverageScore() {
		return averageScore;
	}
	
	/**
	 * 
	 * @param licenseNumber		사업자번호
	 * @param storeName			매장 이름
	 * @param storeTelNumber	매장 전화번호
	 * @param menuCategory		메뉴 유형
	 * @param address			주소
	 * @param score				평점
	 * @param reviewCount		리뷰 갯수
	 * 
	 * Store 클래스의 생성자
	 */
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
	}

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
	
	/**
	 * Data클래스의 reviewList에 들어있는 리뷰들을 모두 반복하여 저장하고
	 * Review 객체에 있는 r 변수의 사업자번호와 현재 Store 클래스의 사업자 번호가 같으면 리뷰 갯수를 1 증가 시킴
	 * @return count
	 */
	public int getReviewCount() {
		int count = 0;
		for(Review r : Data.reviewList) {
			if(r.getLicenseNumber().equals(this.licenseNumber)) {
				count++;
			}
		}
		return count;
	}

//	public Store(String licenseNumber, String storeName, String storeTelNumber, String address, String menuCategory) {
//		super();
//		this.licenseNumber = licenseNumber;
//		this.storeName = storeName;
//		this.storeTelNumber = storeTelNumber;
//		this.address = address;
//		this.menuCategory = menuCategory;
//
//		this.score = score;
//		this.distanceFrom = 0;
//	}
	
	/**
	 * 평점을 얻어오는 getScore 메서드
	 * getReviewCount 메서드와 로직 동일
	 * 리뷰 갯수가 0일때 점수를 매길 수 없으므로 
	 * @return 0.0 반환
	 * 리뷰가 있으면 누적변수 sum과 count 변수의 몫을 반환
	 */
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
	