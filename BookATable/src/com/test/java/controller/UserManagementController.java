package com.test.java.controller;

import java.util.Scanner;

import com.test.java.view.UserManagementView;
import com.test.java.view.View;

public class UserManagementController {
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
				Scanner sc = new Scanner(System.in);
				System.out.println("조회할 회원 종류를 선택하세요.");
				System.out.println("1. 업체 회원");
				System.out.println("2. 일반 회원");
				int input = View.getSelectType();
				if(input == 1) {
					SignOutBusinessUserManagementController signOutBusinessUserManagementController = new SignOutBusinessUserManagementController();
					signOutBusinessUserManagementController.signOutBusinessUserManagement();
				} else if(input == 2) {
					SignOutUserManagementController singOutUserManagementController = new  SignOutUserManagementController();
					singOutUserManagementController.signOutUserManagement();
				}
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
