package com.test.java.model;

import java.util.Calendar;
	
/**
 * 리뷰를 작성하기 위한 WriteReview 클래스
 */
public class WriteReview {
	
	/**
	 * WriteReview 클래스에 필요한 멤버 변수 선언
	 */
	private Calendar reservationDate;
	private String storeName;
	private int numOfPeople;
	private String state;
	
	/**
	 * getter > 각 멤버변수들의 값을 반환
	 * @return
	 */
	public Calendar getReservationDate() {
		return reservationDate;
	}
	public String getStoreName() {
		return storeName;
	}
	public int getNumOfPeople() {
		return numOfPeople;
	}
	public String getState() {
		return state;
	}
	// 리뷰 작성 여부를 반환하는 메서드
	public boolean checkReviewCheck(int reviewCheck) {
		return true;
	}
	
	

}