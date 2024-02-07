package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.PointUsage;
import com.test.java.repository.Data;
import com.test.java.view.MainView;
import com.test.java.view.StoreView;

public class MainController {
	 
	/**
	 * 메인 화면 시작 
	 */
	public static void start() {

		boolean loop = true;
		while(loop) {
			
			if(Member.level == 0) {

				MainView.logo();
				MainView.show();
				int choice = MainView.get();
				
				switch(choice) {
				case 1:
					SignInController signInController = new SignInController();
					signInController.signIn();
					break;
				case 2:
					LogInController logInController = new LogInController();
					logInController.logIn();
					break;
				case 3:
					FindAccountController findAccountController = new FindAccountController();
					findAccountController.findAccount();
					break;
				case 4:
					StoreController storeController = new StoreController();
					storeController.run();
					break;
				default:
					loop = false;
				}
			}
			else if(Member.level == 1) {

				MainView.logo();
				MainView.userPage();
				String licenseNumber="002-00-40342";
				int choice = MainView.get();
				
				switch(choice) {
				case 1:
					UserMyPageController userMyPageController = new UserMyPageController();
					userMyPageController.userMyPage();
					break;
				case 2:
					LogOutController logOutController = new LogOutController();
					logOutController.logOut();
					break;
				case 3:
					UserInquiryController userInquiryController = new UserInquiryController();
					userInquiryController.userInquiry();
					break;
				case 4:
					StoreController storeController = new StoreController();
					storeController.run();
					break;
				default:
					loop = false;
				}
				
			}
			else if(Member.level == 2) {

				MainView.logo();
				MainView.businessUserPage();

				int choice = MainView.get();
				
				switch(choice) {
				case 1:
					BusinessUserMyPageController businessUserMyPageController = new BusinessUserMyPageController();
					businessUserMyPageController.businessUserMyPage();
					break;
				case 2:
					LogOutController logOutController = new LogOutController();
					logOutController.logOut();
					break;
				case 3:
					UserInquiryController userInquiryController = new UserInquiryController();
					userInquiryController.userInquiry();
					break;
				case 4:
					StoreController storeController = new StoreController();
					storeController.run();
					break;
				default:
					loop = false;
				}
			}
			else if(Member.level == 3) {

				MainView.logo();
				MainView.adminPage();

				int choice = MainView.get();
				
				switch(choice) {
				case 1:
					UserManagementController userManagementController = new UserManagementController();
					userManagementController.userManagement();
					break;
				case 2:
					InquiryController inquiryController = new InquiryController();
					inquiryController.inquiryManagement();
					break;
				case 3:
					RequestController requestController = new RequestController();
					requestController.requestManagement();
					break;
				case 4:
					LogOutController logOutController = new LogOutController();
					logOutController.logOut();
					break;
				default:
					loop = false;
				}
			}
		}

	}
	
	private static void searchMenu() {
		StoreView storeView = new StoreView();
		storeView.searchMenu();
	
		
	}

	public static void load() {

//		Data.loadTable();
//		Data.loadOperatingHours();
//		Data.loadAdmin();
		Data.loadUser();
		Data.loadBusinessUser();
//		Data.loadMenu();
//		//Data.loadStore();
//		Data.loadReview();
//		Data.loadReservation();
//		Data.loadStore();
//		//Data.loadBookmark();
//		Data.loadFaq();
//		Data.loadPointUsage();


	}
}
