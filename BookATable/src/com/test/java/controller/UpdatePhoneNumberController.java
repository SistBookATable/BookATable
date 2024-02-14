package com.test.java.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.Validation;
import com.test.java.view.UpdatePhoneNumberView;
import com.test.java.view.View;

/**
 * UpdatePhoneNumberController는 사용자의 전화번호 변경과 관련된 작업을 처리하는 클래스입니다.
 */
public class UpdatePhoneNumberController {

	/**
     * 사용자의 전화번호를 변경하는 메서드입니다.
     */
	public void updatePhoneNumber() {
		boolean loop = true;
		while (loop) {

				String toUpdatePhoneNumber = UpdatePhoneNumberView.getPhoneNumber();
				if (!Validation.isValidPhone(toUpdatePhoneNumber)) {
					UpdatePhoneNumberView.showErrorMessage();
					loop = true;
				} else if (Validation.isValidPhone(toUpdatePhoneNumber)) {
					UpdatePhoneNumberView.showUpdatePhoneNumber(toUpdatePhoneNumber);
					String answer = UpdatePhoneNumberView.getAnswer();
					
					if (!Validation.isValidYorN(answer)) {
						UpdatePhoneNumberView.showUpdateStopMessage();
						loop = true;
					} else {
						updatePhoneNumberToInputPhoneNumber(Member.id, toUpdatePhoneNumber);
						UpdatePhoneNumberView.showUpdatePhoneNumberMessage();
						loop = false;
					}
					
				}

		}

	}

	/**
    * 사용자의 전화번호를 입력받은 전화번호로 변경하는 메서드입니다.
    *
    * @param id                  사용자 ID
    * @param toUpdatePhoneNumber 변경할 전화번호
    */
	private void updatePhoneNumberToInputPhoneNumber(String id, String toUpdatePhoneNumber) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				((User) u).setPhoneNumber(toUpdatePhoneNumber);
			}
		}
	}

}