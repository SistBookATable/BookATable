package com.test.java.controller;

import com.test.java.model.Menu;
import com.test.java.repository.Data;
import com.test.java.view.MenuAddView;

public class MenuAddController {

	public void addMenu(String licenseNumber) {
		
		MenuAddView menuAddView=new MenuAddView();
		String menuName=MenuAddView.getMenuName();
		int menuPrice=MenuAddView.getMenuPrice();
		Menu m=new Menu(licenseNumber,menuName,menuPrice);
		Data.menuList.add(m);
		//TODO 데이터 저장
		for(Menu n:Data.menuList) {
			if(licenseNumber.equals(n.getLicenseNumber())) {
				System.out.println(n.getMenuName());
			}
		}
		
		
	}
	
}