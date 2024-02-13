package com.test.java.model;

/**
 * 즐겨찾기를 나타내는 클래스입니다.
 */

public class Bookmark {
	private String licenseNumber;
	private String userId;
	

	/**
	 * Bookmark 클래스의 생성자
	 * @param licenseNumber 즐겨찾기된 음식점의 사업자등록번호
	 * @param userId 즐겨찾기를 추가한 사용자의 ID
	 */
	public Bookmark(String licenseNumber, String userId) {
		super();
		this.licenseNumber = licenseNumber;
		this.userId = userId;
		
	}

	/**
	 * 즐겨찾기된 음식점의 사업자등록번호를 반환하는 메서드입니다.
	 * @return 즐겨찾기된 음식점의 사업자등록번호
	 */
	public String getLicenseNumber() {
		return licenseNumber;
	}
	
	
	/**
	 * 즐겨찾기를 추가한 사용자의 ID를 반환하는 메서드입니다. 
	 * @return 즐겨찾기를 추가한 사용자의 ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 즐겨찾기된 음식점의 사업자등록번호를 설정하는 메서드입니다.
	 * @param licenseNumber 즐겨찾기된 음식점의 사업자등록번호
	 */
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	@Override
	public String toString() {
		return "Bookmark [licenseNumber=" + licenseNumber + ", userId=" + userId + "]";
	}
	
	
	
}
