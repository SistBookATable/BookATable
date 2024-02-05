package com.test.java.controller;

import java.util.Iterator;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.UserInformationManagementView;

public class UserInformationManagementController {

	public void userInformationManagement() {
		UserInformationManagementView.showUserInformation(findNameById(Member.id)
														 , findIdById(Member.id)
														 , findPhoneNumberById(Member.id)
														 , findBirthById(Member.id));
		
	}

	private String findBirthById(String id) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				
			}
		}
		
		return null;
	}

	private String findPhoneNumberById(String id) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getPhoneNumber();
			}
		}
		
		return null;
	}

	private String findIdById(String id) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return id;
			}
		}
		
		return null;
	}

	private String findNameById(String id) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getName();
			}
		}
		return null;
	}

}
