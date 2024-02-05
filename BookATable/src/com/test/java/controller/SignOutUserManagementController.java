package com.test.java.controller;

import java.util.Calendar;
import java.util.Iterator;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.view.SignInUserManagementView;
import com.test.java.view.SignOutUserManagementView;

public class SignOutUserManagementController {

	SignOutUserManagementView signOutUserManagementView = new SignOutUserManagementView();
	
	public void signOutUserManagement() {
		
		boolean loop = true;
		while(loop) {

			signOutUserManagementView.findAllSignOutUser();
			signOutUserManagementView.showSelectBox();
			int choice = signOutUserManagementView.getSelectType();
			
			if(choice == 1) {
				//탈퇴 회원 정보 삭제 
				
				//아이디 입력 받기
				String id = signOutUserManagementView.getId();
				MemberRepository.deleteUser(id);
				
			}
			else if(choice == 0) {
				loop = false;
			}
			
		}
	}


}
