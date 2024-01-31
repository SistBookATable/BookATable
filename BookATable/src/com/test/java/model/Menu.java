package com.test.java.model;

public class Menu {
	private String name;
	private int price;
	
	public void changeMenu(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void addMenu(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void deleteMenu(String name) {
		this.name = name;
	}
}
