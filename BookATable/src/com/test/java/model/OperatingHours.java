package com.test.java.model;

public class OperatingHours {
	
	private String licenseNumber;
	private String dayOfWeek;
	private String open;
	private String close;
	private String breakStart;
	private String breakEnd;
	
	
	/**
	 * OperatingHours 객체를 생성하는 생성자
	 * @param licenseNumber	사업자 번호
	 * @param dayOfWeek		요일
	 * @param open			영업 시작 시간
	 * @param close			영업 종료 시간
	 * @param breakStart	브레이크타임 시작
	 * @param breakEnd		브레이크타임 종료
	 */
	public OperatingHours(String licenseNumber, String dayOfWeek, String open, String close, String breakStart,
			String breakEnd) {
		super();
		this.licenseNumber = licenseNumber;
		this.dayOfWeek = dayOfWeek;
		this.open = open;
		this.close = close;
		this.breakStart = breakStart;
		this.breakEnd = breakEnd;
	}

	@Override
	public String toString() {
		return "OperatingHours [licenseNumber=" + licenseNumber + ", dayOfWeek=" + dayOfWeek + ", open=" + open
				+ ", close=" + close + ", breakStart=" + breakStart + ", breakEnd=" + breakEnd + "]";
	}
	
	/**
	 * setter > 각 멤버변수들의 값 설정
	 * @param open
	 */
	public void setOpen(String open) {
		this.open = open;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public void setBreakStart(String breakStart) {
		this.breakStart = breakStart;
	}

	public void setBreakEnd(String breakEnd) {
		this.breakEnd = breakEnd;
	}
	
	/**
	 * getter > 각 멤버변수들의 값 반환,
	 * null이면 해당 문자열 반환
	 * @return
	 */
	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public String getOpen() {
		if(open.equals("null")) {
			return "영업";
		}
		return open;
		
	}

	public String getClose() {
		if(close.equals("null")) {
			return "X";
		}
		return close;
	}

	public String getBreakStart() {
		if(breakStart.equals("null")) {
			return "        휴게시간";
		}
		return breakStart;
	}

	public String getBreakEnd() {
		if(breakEnd.equals("null")) {
			return "X";
		}
		return breakEnd;
	}
	
	
	
	
}