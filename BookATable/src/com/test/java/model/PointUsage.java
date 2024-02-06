package com.test.java.model;

public class PointUsage {
	
	private int usageNumber; 
	private int usagePoint;
	private String useTime;
	private String userId;
	private String content;
	
	//TODO save할 때 어떻게 적용할지..!
	
//	private String[] content = {"포인트충전","[예약취소]포인트환급","[예약신청]포인트지불","포인트환불완료","포인트환불신청"};
	
//	public String[] getContent() {
//		return content;
//	}

	
	public PointUsage(int usageNumber,int usagePoint,String useTime, String content, String userId) {
		super();
		this.usageNumber = usageNumber;
		this.usagePoint = usagePoint;
		this.useTime = useTime;
		this.content = content;
		this.userId = userId;
	}
	

	public int getUsageNumber() {
		return usageNumber;
	}

	public String getUseTime() {
		return useTime;
	}



	public String getUserId() {
		return userId;
	}

	public void setUsagePoint(int usagePoint) {
		this.usagePoint = usagePoint;
	}
	
	public int getUsagePoint() {
		return usagePoint;
	}
	
	public String getContent() {
		return content;
	}
	
	public void InqueryPointCharging() {
	
	}
	
	public void InqueryPointRefund() {
		
	}
}
