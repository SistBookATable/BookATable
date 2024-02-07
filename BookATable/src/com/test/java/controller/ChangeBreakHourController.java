 package com.test.java.controller;

import com.test.java.model.OperatingHours;
import com.test.java.repository.Data;
import com.test.java.view.ChangeBreakHourView;
import com.test.java.view.View;


public class ChangeBreakHourController {
	
public void changeBreakHour(String licenseNumber) {
		
		ChangeBreakHourView changeBreakHourView=new ChangeBreakHourView();
		
		changeBreakHourView.changeBreakHour(licenseNumber);
		
		String changeDay=ChangeBreakHourView.getDay();
		
		String changeOpenHour=ChangeBreakHourView.getOpen();
		
		String changeCloseHour=ChangeBreakHourView.getClose();
		
		for(OperatingHours o : Data.operatingHoursList) {
			if(licenseNumber.equals(o.getLicenseNumber())) {
				if(o.getDayOfWeek().equals(changeDay)) {
					System.out.println(o.toString());
					o.setBreakStart(changeOpenHour);
					o.setBreakEnd(changeCloseHour);
					System.out.println(o.toString());
					//TODO 세이브
				}
			}
		}
		
		
		
		System.out.println("수정이 완료 되었습니다.");
		System.out.println();
		
		OperatingHourController operatingHourControleer=new OperatingHourController();
		operatingHourControleer.showOperatingHour(licenseNumber);
		
		
	}

}