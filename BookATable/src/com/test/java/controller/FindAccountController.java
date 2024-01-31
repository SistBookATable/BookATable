package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.FindAccountView;

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
			id = findId(name, phoneNumber);
			FindAccountView.showResultID(id);
			break;
		case 2:
			FindAccountView.showFindPwTitle();
			id = FindAccountView.getId();
			phoneNumber = FindAccountView.getPhoneNumber();
			pw = FindPw(id, phoneNumber);
			FindAccountView.showResultPw(pw);
			break;
		case 0:
			break;
		default:
			break;
		}
	}

	private String FindPw(String id, String phoneNumber) {

		for(Member selected : Data.memberList) {
			if(selected.getId().equals(id) && selected.getPhoneNumber().equals(phoneNumber)){
				return selected.getPw();
			}
		}
		return null;
	}

	public String findId(String name, String phoneNumber) {
		for(Member selected : Data.memberList) {
			if(selected.getName().equals(name) && selected.getPhoneNumber().equals(phoneNumber)){
				return selected.getId();
			}
		}
		return null;
	}

	
	
}
