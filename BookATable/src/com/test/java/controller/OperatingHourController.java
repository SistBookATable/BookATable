package com.test.java.controller;

import java.util.HashMap;
import java.util.Map;

import com.test.java.model.Menu;
import com.test.java.model.OperatingHours;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.OperatingHourView;
import com.test.java.view.OperationalInfoManagementView;

public class OperatingHourController {
	

	public void showOperatingHour(String licenseNumber) {
		
		OperatingHourView operatingHourView=new OperatingHourView(); 
		operatingHourView.showOperatingHour(licenseNumber);
		
		
		
		boolean loop = true;
			
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
			case 3:
			
				break;

			

			case 0:

			}
		
		
	}
	
}