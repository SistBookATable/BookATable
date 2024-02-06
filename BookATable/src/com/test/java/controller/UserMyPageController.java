package com.test.java.controller;

import com.test.java.view.UserMyPageView;

public class UserMyPageController {

	public void userMyPage() {
		boolean loop = true;
		while (loop) {
			UserMyPageView.showUserMyPage();
			int choice = UserMyPageView.get();
			switch (choice) {
			case 1:
				ReservationManagementController reservationManagementController = new ReservationManagementController(); 
				reservationManagementController.reservationManagement();
				break;
			case 2:
				PointManagementController pointManagementController = new PointManagementController();
				pointManagementController.pointManagement();
				break;
			case 3:
				FavouriteStoreManagementController favouriteStoreManagementController = new FavouriteStoreManagementController();
				favouriteStoreManagementController.favouriteStoreManagement();
				break;

			case 4:
				break;

			case 5:
				break;

			case 6:
				break;

			case 0:

			}
		}

	}

}
