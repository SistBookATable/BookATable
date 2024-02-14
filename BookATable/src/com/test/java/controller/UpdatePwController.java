package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.Validation;
import com.test.java.view.UpdatePwView;

/**
 * UpdatePwController는 사용자의 비밀번호를 변경하는 기능을 담당하는 클래스입니다.
 */
public class UpdatePwController {

	/**
     * 사용자의 비밀번호를 변경하는 메서드입니다.
     */
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

	 /**
     * 사용자의 비밀번호를 입력한 비밀번호로 변경하는 메서드입니다.
     *
     * @param id          사용자 ID
     * @param toUpdatePw 변경할 비밀번호
     */
	private void updatePwToInputPW(String id, String toUpdatePw) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				((User)u).setPw(toUpdatePw);
			}
		}
		
	}


}
