package com.test.java.controller;

import com.test.java.view.UserManagementView;

public class UserManagementController {

	public void userManagement() {
		boolean loop = true;
		while(loop) {
			UserManagementView.showTitle();
			UserManagementView.showSelectBox();
			int choice = UserManagementView.getSelectType();
			
			switch(choice) {
			case 1:
				SignInUserManagementController signInUserManagementController = new SignInUserManagementController();
				signInUserManagementController.signInUserManagement();
				break;
			case 2:
				SignOutUserManagementController singOutUserManagementController = new  SignOutUserManagementController();
				singOutUserManagementController.signOutUserManagement();
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
