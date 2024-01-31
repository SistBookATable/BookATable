package com.test.java.model;

public class Menu {
	private String licenseNumber;
	private String menuName;
	private int price;
	
	public void changeMenu(String licenseNumbe,String menuName, int price) {
		this.menuName = menuName;
		this.price = price;
	}
	
	public void addMenu(String licenseNumbe,String menuName, int price) {
		this.menuName = menuName;
		this.price = price;
	}
	
	public void deleteMenu(String licenseNumbe,String menuName) {
		this.menuName = menuName;
	}
}
