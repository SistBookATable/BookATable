package com.test.java.model;

import java.util.Calendar;

/**
 * 포인트 환불 정보를 담는 클래스
 */
public class PointRefund {
	private String userId;
	private String refundDate;
	private int pointAmount;
	
	/**
	 * 
	 * @param refundDate 환불 신청 날짜
	 * @param pointAmount 환불된 포인트 금액
	 * @param userId 사용자 아이디
	 */
	public PointRefund(String refundDate, int pointAmount, String userId) {
		super();
		this.refundDate = refundDate;
		this.pointAmount = pointAmount;
		this.userId = userId;
		
		
	}
	
	/**
	 * 사용자 아이디 반환
	 * @return 사용자 아이디
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 환불 신청 날짜 반환
	 * @return 환불 신청 날짜
	 */
	public String getRefundDate() {
		return refundDate;
	}
	
	/**
	 * 환불된 포인트 금액 반환
	 * @return 환불된 포인트 금액
	 */

	public int getPointAmount() {
		return pointAmount;
	}

	/**
	 * 환불된 포인트 금액 설정
	 * @param pointAmount 환불된 포인트 금액
	 */
	public void setPointAmount(int pointAmount) {
		this.pointAmount = pointAmount;
	}

}
