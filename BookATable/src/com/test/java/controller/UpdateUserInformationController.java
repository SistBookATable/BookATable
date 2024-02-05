package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.UpdateUserInformationView;
import com.test.java.view.View;

public class UpdateUserInformationController {

	public void updateUserInformation() {
		
		boolean loop = true;

		while(loop) {
			UpdateUserInformationView.show();
			UpdateUserInformationView.showSelectBox();
			
			int choice = UpdateUserInformationView.get();
			
			switch(choice) {
			case 1:
				//비밀번호 변경
				String inputPw = UpdateUserInformationView.getPw();
				if (!isValidPw(inputPw, Member.id)) {
					System.out.println("비밀번호를 잘못 입력하셨습니다.");
					View.pause();
					loop = true;
				} else {
					UpdatePwController updatePwController = new UpdatePwController();
					updatePwController.updatePw();
					loop = false;
				}
				break;
			case 2:
				//계좌 변경
				inputPw = UpdateUserInformationView.getPw();
				if (!isValidPw(inputPw, Member.id)) {
					System.out.println("비밀번호를 잘못 입력하셨습니다.");
					View.pause();
					loop = true;
				} else {
					UpdateAccountController updateAccountController = new UpdateAccountController();
					updateAccountController.updateAccount();
					loop = false;
				}
				break;
				
			case 3: 
				//전화번호 변경
				inputPw = UpdateUserInformationView.getPw();
				if (!isValidPw(inputPw, Member.id)) {
					System.out.println("비밀번호를 잘못 입력하셨습니다.");
					View.pause();
					loop = true;
				} else {
					UpdatePhoneNumberController updatePhoneNumberController = new UpdatePhoneNumberController(); 
					updatePhoneNumberController.updatePhoneNumber();
					loop = false;
				}
				break;
				
			case 0:
				//이전 화면
				loop = false;
				break;
			}
			
		}
		
	}

	private boolean isValidPw(String inputPw, String id) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				if (u.getPw().equals(inputPw)) {
					return true;
				}
			}
		}
		return false;
		
	}

}
