package com.test.java.controller;

import java.text.DecimalFormat;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.view.UserInformationManagementView;

/**
 * UserInformationManagementController는 사용자 정보 관리와 관련된 화면 출력 및 기능을 담당하는 클래스입니다.
 */
public class UserInformationManagementController {

	/**
     * 사용자 정보를 관리하는 메서드입니다.
     */
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
				 // 사용자 정보 수정 컨트롤러 호출
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
