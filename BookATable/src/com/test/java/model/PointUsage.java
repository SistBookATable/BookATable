package com.test.java.model;

public class PointUsage {
	
	private int usageNumber; 
	private int amountCharging;
	private String useTime;
	private String content;
	private String userId;
	
	
	public PointUsage(int usageNumber, int amountCharging, String useTime, String content, String userId) {
		super();
		this.usageNumber = usageNumber;
		this.amountCharging = amountCharging;
		this.useTime = useTime;
		content = content;
		this.userId = userId;
	}
	

	public int getUsageNumber() {
		return usageNumber;
	}

	public String getUseTime() {
		return useTime;
	}

	public String getContent() {
		return content;
	}

	public String getUserId() {
		return userId;
	}

	public void setAmountCharging(int amountCharging) {
		this.amountCharging = amountCharging;
	}
	
	public int getAmountCharging() {
		return amountCharging;
	}
	
	public void InqueryPointCharging() {
		
	}
	
	public void InqueryPointRefund() {
		
	}
}
