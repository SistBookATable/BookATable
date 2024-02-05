package com.test.java.controller;

import com.test.java.view.MenuManagementView;
import com.test.java.view.OperationalInfoManagementView;

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
		
			break;

		

		case 0:

		}
	}
	
}