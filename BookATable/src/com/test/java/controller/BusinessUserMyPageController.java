package com.test.java.controller;

import com.test.java.view.BusinessUserMyPageView;

public class BusinessUserMyPageController {

	public void businessUserMyPage() {

		BusinessUserMyPageView businessUserMyPageView = new BusinessUserMyPageView();
		
		boolean loop = true;
		while(loop) {
			String licenseNumber="002-00-40342";
			businessUserMyPageView.showTitle();
			businessUserMyPageView.showSelectBox();
			int choice = businessUserMyPageView.getSelectType();
			
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
				SalesManagementController salesManagementController = new SalesManagementController();
				salesManagementController.salesManagemnet();
				break;
			case 4:
				OperationalInfoManagementController operationalInfoManagementController= new OperationalInfoManagementController();
				operationalInfoManagementController.operationalInfoManagement(licenseNumber);
				break;
			case 5:
				break;
			case 6:
				MembershipWithdrawalController membershipWithdrawalController = new MembershipWithdrawalController();
				membershipWithdrawalController.membershipWithdrawal();
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
