package com.test.java.model;

public class OperatingHours {
	
	private String licenseNumber;
	private String dayOfWeek;
	private String open;
	private String close;
	private String breakStart;
	private String breakEnd;
	
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
			return "휴게시간";
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
