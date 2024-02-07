package com.test.java.controller;

import com.test.java.repository.MemberRepository;
import com.test.java.view.FindAccountView;
import com.test.java.view.View;

public class FindAccountController {

	public void findAccount() {
		FindAccountView.showSelectBox();
		int choice = FindAccountView.getSelectNum();
		
		String name = "";
		String phoneNumber = "";
		String id = "";
		String pw = "";
		
		switch(choice) {
		case 1:
			FindAccountView.showFindIdTitle();
			name = FindAccountView.getName();
			phoneNumber = FindAccountView.getPhoneNumber();
			id = MemberRepository.findId(name, phoneNumber);
			FindAccountView.showResultID(id);
			break;
		case 2:
			FindAccountView.showFindPwTitle();
			id = FindAccountView.getId();
			phoneNumber = FindAccountView.getPhoneNumber();
			pw = MemberRepository.findPw(id, phoneNumber);
			FindAccountView.showResultPw(pw);
			break;
		case 0:
			break;
		default:
			break;
		}
		
		View.pause();
	}
	
}
