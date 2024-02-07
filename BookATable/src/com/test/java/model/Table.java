package com.test.java.model;

public class Table {
	
	private String licenseNumber;
	private int tableCapacity;
	private int number;
	private boolean usage;
	
	public Table(String licenseNumber, int tableCapacity, int number, boolean usage) {
		super();
		this.licenseNumber = licenseNumber;
		this.tableCapacity = tableCapacity;
		this.number = number;
		this.usage = usage;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public int getTableCapacity() {
		return tableCapacity;
	}

	public int getNumber() {
		return number;
	}

	public boolean isUsage() {
		return usage;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setUsage(boolean usage) {
		this.usage = usage;
	}

	
	

}
