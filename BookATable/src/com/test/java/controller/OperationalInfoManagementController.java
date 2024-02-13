package com.test.java.controller;

import com.test.java.view.OperationalInfoManagementView;

// 운영 관리 컨트롤러
public class OperationalInfoManagementController {
	

	public void operationalInfoManagement(String licenseNumber) {
		

		OperationalInfoManagementView operationalView=new OperationalInfoManagementView();
		operationalView.showChoice();
		boolean loop = true;
		while (loop) {
			
			int choice = OperationalInfoManagementView.get();
			switch (choice) {
			case 1:
				OperatingHourController operatingHourController= new OperatingHourController();
				operatingHourController.showOperatingHour(licenseNumber);
				
				break;
			case 2:
				MenuManagementController menuManagementController=new MenuManagementController();
				menuManagementController.showMenuManagement(licenseNumber);
				
				break;
			case 3:
				TableManagementController tableManagementController = new TableManagementController();
				tableManagementController.showTableManagement(licenseNumber);
			
				break;

			

			case 0:
				BusinessUserMyPageController back= new BusinessUserMyPageController();
				back.businessUserMyPage();
			}
		}

	}

}
	
	
