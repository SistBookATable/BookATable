package com.test.java.controller;

import com.test.java.view.UserManagementView;

public class BusinessUserManagementController {
	UserManagementView userManagementView = new UserManagementView();

	public void userManagement() {
		boolean loop = true;
		while(loop) {
			userManagementView.showTitle();
			userManagementView.showSelectBox();
			int choice = userManagementView.getSelectType();
			
			switch(choice) {
			case 1:
				//가입 회원 조회
				SignInUserManagementController signInUserManagementController = new SignInUserManagementController();
				signInUserManagementController.signInUserManagement();
				break;
			case 2:
				//탈퇴 회원 조회
				SignOutUserManagementController singOutUserManagementController = new  SignOutUserManagementController();
				singOutUserManagementController.signOutUserManagement();
				break;
			case 0:
				loop = false;
				break;
			default:
				userManagementView.incorrectInputMessgae();
			}
			
		}
	}

}
