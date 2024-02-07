package com.test.java.controller;

import java.text.DecimalFormat;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.view.UserInformationManagementView;

public class UserInformationManagementController {

	public void userInformationManagement() {

		boolean loop = true;
		while (loop) {
			String id = Member.id;
			User user = (User)MemberRepository.findOneById(id);
			String userName = user.getName();
			String phoneNumber = user.getPhoneNumber();
			String birthDate =  user.getBirth(); 
			String account = user.getAccount();

			DecimalFormat df = new DecimalFormat("###,###");
			String balance = df.format(user.getBalance());

			UserInformationManagementView.showTitle(userName);
			UserInformationManagementView.showUserInformation(userName, id, phoneNumber, birthDate, account, balance);
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

}
