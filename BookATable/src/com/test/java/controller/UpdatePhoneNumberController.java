package com.test.java.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.UpdatePhoneNumberView;
import com.test.java.view.View;

public class UpdatePhoneNumberController {

	public void updatePhoneNumber() {
		boolean loop = true;
		while (loop) {

				String toUpdatePhoneNumber = UpdatePhoneNumberView.getPhoneNumber();
				if (!isValidOfPhoneNumber(toUpdatePhoneNumber)) {
					System.err.println("전화번호를 숫자와 “-”로만 구성하여  [000-0000-0000] 형식으로 작성하십시오");
					loop = true;
				} else if (isValidOfPhoneNumber(toUpdatePhoneNumber)) {
					UpdatePhoneNumberView.showUpdatePhoneNumber(toUpdatePhoneNumber);
					String answer = UpdatePhoneNumberView.getAnswer();
					
					if (answer.equalsIgnoreCase("N")) {
						System.out.println("전화번호 변경을 취소하겠습니다.\n");
						System.out.println("다시 입력해주시길 바랍니다.\n");
						View.pause();
						loop = true;
					} else if (answer.equalsIgnoreCase("Y")) {
						updatePhoneNumberToInputPhoneNumber(Member.id, toUpdatePhoneNumber);
						System.out.println("계좌번호가 변경되었습니다.\n");
						View.pause();
						loop = false;
					}
					
				}

		}

	}

	private boolean isValidOfPhoneNumber(String toUpdatePhoneNumber) {
		String regex = "^\\d{3}-\\d{4}-\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(toUpdatePhoneNumber);
		return matcher.matches();
	}

	private void updatePhoneNumberToInputPhoneNumber(String id, String toUpdatePhoneNumber) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				((User) u).setPhoneNumber(toUpdatePhoneNumber);
			}
		}
	}

}