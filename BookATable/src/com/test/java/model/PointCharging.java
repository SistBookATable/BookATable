package com.test.java.model;

public class PointCharging {

	private int amountCharging;
	private String pw;
	
	public PointCharging(int amountCharging, String pw) {
		this.amountCharging = amountCharging;
		this.pw = pw;
		
	}
	
	
	
	public void addBalance(String userid, int price) {
		
		// find id > balance 에 price 값만큼 충전
		
	}
	public boolean checkPw(String pw) {
		
		return false;
	}
}
