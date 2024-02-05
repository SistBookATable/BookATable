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

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public String getOpen() {
		return open;
	}

	public String getClose() {
		return close;
	}

	public String getBreakStart() {
		return breakStart;
	}

	public String getBreakEnd() {
		return breakEnd;
	}
	
	
	
	
}
