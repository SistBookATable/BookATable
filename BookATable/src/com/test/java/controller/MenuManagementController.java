package com.test.java.controller;

import com.test.java.view.MenuManagementView;

// 메뉴 관리 선택 컨트롤러
public class MenuManagementController {

	public void showMenuManagement(String licenseNumber) {
		
		MenuManagementView menuManagementView=new MenuManagementView();
		menuManagementView.showChoice();
		
		int choice = MenuManagementView.get();
		
		switch (choice) {
		case 1:
			MenuAddController menuAddController=new MenuAddController();
			menuAddController.addMenu(licenseNumber);
			
			break;
			
		case 2:
			MenuEditController menuEditController=new MenuEditController();
			menuEditController.editMenu(licenseNumber);
			
			break;
			
		case 3:
			MenuRemoveController menuRemoveController = new MenuRemoveController();
			menuRemoveController.removeMenu(licenseNumber);
		
			break;

		

		case 0:
			OperationalInfoManagementController back= new OperationalInfoManagementController();
			back.operationalInfoManagement(licenseNumber);
			break;
		}
	}
	
}