package com.test.java.model;

/**
 * 테이블 정보를 가지는 Table 클래스
 */
public class Table {
	
	private String licenseNumber;
	private int tableCapacity;
	private int number;
	private boolean usage;
	
	/**
	 * Table 클래스의 객체를 생성하는 생성자
	 * @param licenseNumber	사업자 번호
	 * @param tableCapacity	테이블 용량
	 * @param number		테이블 번호
	 * @param usage			테이블 사용가능여부
	 */
	public Table(String licenseNumber, int tableCapacity, int number, boolean usage) {
		super();
		this.licenseNumber = licenseNumber;
		this.tableCapacity = tableCapacity;
		this.number = number;
		this.usage = usage;
	}
	/**
	 * getter > 각 멤버변수들의 값을 반환
	 * setter > 각 멤버변수들의 값을 설정
	 * @return
	 */
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
