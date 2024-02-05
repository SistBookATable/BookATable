package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.UpdatePwView;
import com.test.java.view.View;

public class UpdatePwController {

	public void updatePw() {
		//변경할 비밀번호 입력받기
		String toUpdatePw = UpdatePwView.getPw();
		
		//현재 유저의 비밀번호를 입력받은 비밀번호로 변경
		updatePwToInputPW(Member.id, toUpdatePw);
		
		System.out.println(toUpdatePw);
		
		//TODO 유효성 검사
		//isVaildOfPw(toUpdatePw);
		
		System.out.println("비밀번호가 변경되었습니다.");
		
		View.pause();
	}

	private void updatePwToInputPW(String id, String toUpdatePw) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				((User)u).setPw(toUpdatePw);
			}
		}
		
	}


}
