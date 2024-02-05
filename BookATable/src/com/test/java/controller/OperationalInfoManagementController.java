package com.test.java.controller;

import com.test.java.view.OperationalInfoManagementView;


public class OperationalInfoManagementController {
	
	public void operationalInfoManagement() {
		String licenseNumber="002-00-40342";
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
			
				break;

			

			case 0:

			}
		}

	}

}
	
	
	

