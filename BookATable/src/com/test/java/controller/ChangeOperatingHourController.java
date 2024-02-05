package com.test.java.controller;

import com.test.java.model.OperatingHours;
import com.test.java.repository.Data;
import com.test.java.view.ChangeOperatingHourView;

public class ChangeOperatingHourController {

	public void changeOperatingHour(String licenseNumber) {
		
		ChangeOperatingHourView changeOperatingHourView=new ChangeOperatingHourView();
		
		changeOperatingHourView.changeOperatingHour(licenseNumber);
		
		String changeDay=ChangeOperatingHourView.getDay();
		
		String changeOpenHour=ChangeOperatingHourView.getOpen();
		
		String changeCloseHour=ChangeOperatingHourView.getClose();
		
		for(OperatingHours o : Data.operatingHoursList) {
			if(licenseNumber.equals(o.getLicenseNumber())) {
				if(o.getDayOfWeek().equals(changeDay)) {
					System.out.println(o.toString());
					o.setOpen(changeOpenHour);
					o.setClose(changeCloseHour);
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
