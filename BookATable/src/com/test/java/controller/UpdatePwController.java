package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.Validation;
import com.test.java.view.UpdatePwView;

public class UpdatePwController {

	public void updatePw() {
		
		boolean loop = true;
		while(loop) {
			String toUpdatePw = UpdatePwView.getPw();
			
			if (!Validation.isValidPw(toUpdatePw)) {
				UpdatePwView.showErrorMessage();
				loop = true;
			} else {
				updatePwToInputPW(Member.id, toUpdatePw);
				System.out.println(toUpdatePw);
				UpdatePwView.showUpdatePwMessage();
				loop = false;
			}
		}
	}

	private void updatePwToInputPW(String id, String toUpdatePw) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				((User)u).setPw(toUpdatePw);
			}
		}
		
	}


}
