package com.test.java.model;

/**
 * 포인트 사용 내역을 저장하는 클래스입니다.
 */

public class PointUsage {
	
	private static int COUNT = 1;
	private int usageNumber; 
	private int usagePoint;
	private String useTime;
	private String content;
	private String userId;
	
	//TODO save할 때 어떻게 적용할지..!
	
//	private String[] content = {"포인트충전","[예약취소]포인트환급","[예약신청]포인트지불","포인트환불완료","포인트환불신청"};
	
//	public String[] getContent() {
//		return content;
//	}

	
	/**
	 * 
	 * @param usageNumber 번호
	 * @param usagePoint 사용 포인트
	 * @param useTime 사용 시간
	 * @param content 사용 내용
	 * @param userId 사용자 ID
	 */
	public PointUsage(int usageNumber,int usagePoint,String useTime, String content, String userId) {
		super();
		this.usageNumber = COUNT++;
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


	@Override
	public String toString() {
		return "PointUsage [usageNumber=" + usageNumber + ", usagePoint=" + usagePoint + ", useTime=" + useTime
				+ ", content=" + content + ", userId=" + userId + "]";
	}
	
	
}
