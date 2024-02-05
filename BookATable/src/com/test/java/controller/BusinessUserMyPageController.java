package com.test.java.controller;

import com.test.java.view.BusinessUserMyPageView;

public class BusinessUserMyPageController {

	public void businessUserMyPage() {

		BusinessUserMyPageView businessUserMyPageView = new BusinessUserMyPageView();
		
		boolean loop = true;
		while(loop) {
			
			businessUserMyPageView.showTitle();
			businessUserMyPageView.showSelectBox();
			int choice = businessUserMyPageView.getSelectType();
			String licenseNumber="002-00-40342";
			switch(choice) {
			case 1:
				ReservationController reservationController = new ReservationController();
				reservationController.BusinessUserReservationManagement();
				break;
			case 2:
				RevenueManagementController revenueManagementController = new RevenueManagementController();
				revenueManagementController.revenueManagement();
				break;
			case 3:
				break;
			case 4:
				OperationalInfoManagementController operationalInfoMangagementController=new OperationalInfoManagementController();
				operationalInfoMangagementController.operationalInfoManagement(licenseNumber);
				break;
			case 5:
				break;
			case 6:
				break;
			case 0:
				loop = false;
				break;
			default:
				loop = false;
			}
			
		}
		
	}

}
