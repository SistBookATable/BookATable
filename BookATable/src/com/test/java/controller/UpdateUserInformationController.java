package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.repository.Validation;
import com.test.java.view.UpdateUserInformationView;
import com.test.java.view.View;

/**
 * UpdateUserInformationController는 사용자 정보 수정에 관련된 기능을 담당하는 클래스입니다.
 */
public class UpdateUserInformationController {

	/**
     * 사용자 정보 수정 화면을 제어하는 메서드입니다.
     */
	public void updateUserInformation() {
		
		boolean loop = true;

		while(loop) {
			UpdateUserInformationView.show();
			UpdateUserInformationView.showSelectBox();
			
			int choice = UpdateUserInformationView.get();
			String inputPw = UpdateUserInformationView.getPw();
			boolean isValidPw = Validation.isValidPwWithInput(Member.id, inputPw);

			switch(choice) {
			case 1:
				//비밀번호 변경
				if (!isValidPw) {
					UpdateUserInformationView.showErrorMessage();
					loop = true;
				} else {
					UpdatePwController updatePwController = new UpdatePwController();
					updatePwController.updatePw();
					loop = false;
				}
				break;
			case 2:
				//계좌 변경
				if (!isValidPw) {
					UpdateUserInformationView.showErrorMessage();
					loop = true;
				} else {
					UpdateAccountController updateAccountController = new UpdateAccountController();
					updateAccountController.updateAccount();
					loop = false;
				}
				break;
				
			case 3: 
				//전화번호 변경
				if (!isValidPw) {
					UpdateUserInformationView.showErrorMessage();
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

}
