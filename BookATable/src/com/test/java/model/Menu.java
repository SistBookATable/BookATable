package com.test.java.model;

/**
 * 메뉴의 정보를 담고있는 Menu 클래스
 */
public class Menu {

	private String licenseNumber;
	private String menuName;
	private int price;
	
	/**
	 * Menu 클래스의 생성자
	 * @param licenseNumber	사업자 번호
	 * @param menuName		메뉴 이름
	 * @param price			가격
	 */
	public Menu(String licenseNumber, String menuName, int price) {
		super();
		this.licenseNumber = licenseNumber;
		this.menuName = menuName;
		this.price = price;
	}

	
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

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getMenuName() {
		return menuName;
	}

	public int getPrice() {
		return price;
	}



	@Override
	public String toString() {
		return "Menu [ licenseNumber=" + licenseNumber + ", menuName=" + menuName + ", price="
				+ price + "]";
	}
	
	
	
}