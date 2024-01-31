package com.test.java.model;

import java.util.Calendar;

public class PointRefund {
	private String userId;
	private String userAccount;
	
	// 환불신청내역
	private Calendar refundDate;
	private int pointAmount;
	
	public boolean checkUserAccount(String userAccount) {
		return false;
	}
}
