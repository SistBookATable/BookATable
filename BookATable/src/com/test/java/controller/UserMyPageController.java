package com.test.java.controller;

import com.test.java.view.UserMyPageView;

public class UserMyPageController {

	public void userMyPage() {
		UserMyPageView.showUserMyPage();
		int choice = UserMyPageView.get();

		boolean loop = true;

		while (loop) {

			switch (choice) {
			case 1:
				ReservationManagementController reservationManagementController = new ReservationManagementController(); 
				reservationManagementController.reservationStatusInquiry();
				break;
			case 2:
				PointManagementController pointManagementController = new PointManagementController();
				pointManagementController.pointManagement();
				break;

			case 3:
				break;

			case 4:
				break;

			case 5:
				break;

			case 6:
				break;

			case 0:
				break;

			}
		}

	}

}
