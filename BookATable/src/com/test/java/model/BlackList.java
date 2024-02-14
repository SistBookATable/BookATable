package com.test.java.model;

/**
 * 블랙리스트를 나타내는 BlackList 클래스
 */
public class BlackList {
	private String licenseNumber;
	private String UserId;
	
	/**
	 * BlackList 클래스의 생성자
	 * @param licenseNumber 사업자 번호
	 * @param userId		사용자ID
	 */
	public BlackList(String licenseNumber, String userId) {
		super();
		this.licenseNumber = licenseNumber;
		this.UserId = userId;
	}
	
	/**
	 * 사업자 번호를 반환
	 * @return licenseNumber
	 */
	public String getLicenseNumber() {
		return licenseNumber;
	}

	/**
	 * 사용자 ID를 반환
	 * @return UserId
	 */
	public String getUserId() {
		return UserId;
	}

	
	@Override
	public String toString() {
		return "BlackList [licenseNumber=" + licenseNumber + ", UserId=" + UserId + "]";
	}
	
}
