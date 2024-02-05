package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.UpdateAccountView;
import com.test.java.view.UpdatePhoneNumberView;
import com.test.java.view.View;

public class UpdatePhoneNumberController {

	public void updatePhoneNumber() {
		boolean loop = true;
		while(loop) {
			String toUpdatePhoneNumber = UpdatePhoneNumberView.getPhoneNumber();
			
			
			//TODO 유효성 검사
			//isValidOf(toUpdatePhoneNumber)
			UpdatePhoneNumberView.showUpdatePhoneNumber(toUpdatePhoneNumber);
			String answer = UpdatePhoneNumberView.getAnswer();
			if (answer.equalsIgnoreCase("N")) {
				System.out.println("전화번호 변경을 취소하겠습니다.\n");
				System.out.println("다시 입력해주시길 바랍니다.\n");
				View.pause();
				loop = true;
			} else if (answer.equalsIgnoreCase("Y")){
				updatePhoneNumberToInputPhoneNumber(Member.id, toUpdatePhoneNumber);
				System.out.println("계좌번호가 변경되었습니다.\n");
				View.pause();
				loop = false;
			}
			
		}
		
	}

	private void updatePhoneNumberToInputPhoneNumber(String id, String toUpdatePhoneNumber) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				((User)u).setPhoneNumber(toUpdatePhoneNumber);
			}
		}
	}

}