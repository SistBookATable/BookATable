package com.test.java.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.Validation;
import com.test.java.view.UpdatePhoneNumberView;
import com.test.java.view.View;

public class UpdatePhoneNumberController {

	public void updatePhoneNumber() {
		boolean loop = true;
		while (loop) {

				String toUpdatePhoneNumber = UpdatePhoneNumberView.getPhoneNumber();
				if (!Validation.isValidPhone(toUpdatePhoneNumber)) {
					UpdatePhoneNumberView.showErrorMessage();
					loop = true;
				} else if (isValidOfPhoneNumber(toUpdatePhoneNumber)) {
					UpdatePhoneNumberView.showUpdatePhoneNumber(toUpdatePhoneNumber);
					String answer = UpdatePhoneNumberView.getAnswer();
					
					if (answer.equalsIgnoreCase("N")) {
						UpdatePhoneNumberView.showUpdateStopMessage();
						loop = true;
					} else if (answer.equalsIgnoreCase("Y")) {
						updatePhoneNumberToInputPhoneNumber(Member.id, toUpdatePhoneNumber);
						UpdatePhoneNumberView.showUpdatePhoneNumberMessage();
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