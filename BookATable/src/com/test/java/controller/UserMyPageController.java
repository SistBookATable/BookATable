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
				reservationManagementController.reservaionManagement();
			case 2:
				PointManagementController pointManage

			case 3:

			case 4:

			case 5:

			case 6:

			case 0:

			}
		}

	}

}
