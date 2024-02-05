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
				//예약 관리
				ReservationManagementController reservationManagementController = new ReservationManagementController(); 
				reservationManagementController.reservationManagement();
				break;
			case 2:
				//포인트 관리
				PointManagementController pointManagementController = new PointManagementController();
				pointManagementController.pointManagement();
				break;
			case 3:
				//관심매장 관리
				FavouriteStoreManagementController favouriteStoreManagementController = new FavouriteStoreManagementController();
				favouriteStoreManagementController.favouriteStoreManagement();
				break;

			case 4:
				//개인정보 관리
				UserInformationManagementController userInformationManagementController = new UserInformationManagementController() ;
				userInformationManagementController.userInformationManagement();
				break;

			case 5:
				//회원 탈퇴
				UserCancellationController userCancellationController = new UserCancellationController();
				userCancellationController.UserCancellation();
				break;

			case 0:
				loop = false;
				break;

			}
		}

	}

}
