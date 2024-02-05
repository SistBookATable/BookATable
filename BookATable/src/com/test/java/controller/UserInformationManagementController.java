package com.test.java.controller;

import java.util.Iterator;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.UserInformationManagementView;

public class UserInformationManagementController {

	public void userInformationManagement() {

		boolean loop = true;
		while (loop) {
			UserInformationManagementView.showUserInformation(findNameById(Member.id), findIdById(Member.id),
					findPhoneNumberById(Member.id), findBirthById(Member.id), findAccountById(Member.id),
					findBalanceById(Member.id));
			UserInformationManagementView.showSelectBox();
			int choice = UserInformationManagementView.get();

			switch (choice) {
			case 1:
				UpdateUserInformationController updateUserInformationController = new UpdateUserInformationController();
				updateUserInformationController.updateUserInformation();
				break;
			case 0:
				loop = false;
				break;
			}

		}

	}

	private int findBalanceById(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return ((User) u).getBalance();
			}
		}

		return 0;
	}

	private String findAccountById(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getAccount();
			}
		}
		return null;
	}

	private String findBirthById(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return ((User) u).getBirth();
			}
		}
		return null;
	}

	private String findPhoneNumberById(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getPhoneNumber();
			}
		}
		return null;

	}

	private String findIdById(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return id;
			}
		}
		return null;
	}

	private String findNameById(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getName();
			}
		}
		return null;
	}

}
