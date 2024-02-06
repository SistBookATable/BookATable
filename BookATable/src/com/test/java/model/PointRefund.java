package com.test.java.model;

import java.util.Calendar;

public class PointRefund {
	private String userId;
	private String refundDate;
	private int pointAmount;
	
	public PointRefund(String refundDate, int pointAmount, String userId) {
		super();
		this.refundDate = refundDate;
		this.pointAmount = pointAmount;
		this.userId = userId;
		
		
	}

	public String getUserId() {
		return userId;
	}

	public String getRefundDate() {
		return refundDate;
	}

	public int getPointAmount() {
		return pointAmount;
	}

}
