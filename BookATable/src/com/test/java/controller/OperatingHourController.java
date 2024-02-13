package com.test.java.controller;





import com.test.java.view.OperatingHourView;


public class OperatingHourController {
	
	//운영 시간 관리 선택 화면 컨트롤러
	public void showOperatingHour(String licenseNumber) {
		
		OperatingHourView operatingHourView=new OperatingHourView(); 
		operatingHourView.showOperatingHour(licenseNumber);
		
		
		
		boolean loop = true;
			while(loop) {
			int choice = OperatingHourView.get();
			switch (choice) {
			case 1:
				ChangeOperatingHourController changeOperatingHourController= new ChangeOperatingHourController();
				changeOperatingHourController.changeOperatingHour(licenseNumber);
				
				break;
			case 2:
				ChangeBreakHourController changeBreakHourController=new ChangeBreakHourController();
				changeBreakHourController.changeBreakHour(licenseNumber);
				
				break;

			

			case 0:
				OperationalInfoManagementController back= new OperationalInfoManagementController();
				back.operationalInfoManagement(licenseNumber);
				
			default: 
				OperationalInfoManagementController back2= new OperationalInfoManagementController();
				back2.operationalInfoManagement(licenseNumber);
			}
			}
		
		
	}
	
}