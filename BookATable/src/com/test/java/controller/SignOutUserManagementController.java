package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.User;
import com.test.java.repository.MemberRepository;
import com.test.java.view.SignOutUserManagementView;

public class SignOutUserManagementController {

	SignOutUserManagementView signOutUserManagementView = new SignOutUserManagementView();
	
	public void signOutUserManagement() {
		
		boolean loop = true;
		while(loop) {
			signOutUserManagementView.showTitle();
			ArrayList<User> userList = MemberRepository.findAllSingOutUser();
			signOutUserManagementView.showAllSignOutUser(userList);
			signOutUserManagementView.showSelectBox();
			int choice = signOutUserManagementView.getSelectType();
			
			switch(choice) {
			case 1:
				//탈퇴 회원 정보 삭제 
				
				//아이디 입력 받기
				String id = signOutUserManagementView.getId();
				MemberRepository.deleteUser(id);
				
				break;
			case 0:
				loop = false;
				break;
			default:
				signOutUserManagementView.incorrectInputMessage();
			}
		}
	}


}
