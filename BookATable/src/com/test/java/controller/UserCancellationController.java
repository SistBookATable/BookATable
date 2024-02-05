package com.test.java.controller;

import java.util.Calendar;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.UserCancellationView;

public class UserCancellationController {

	public void UserCancellation() {
		
		boolean loop = true;
		while(loop) {
			UserCancellationView.show();
			String inputPw = UserCancellationView.getPw();
			String pw = findPwById(Member.id);
			
			if (!inputPw.equals(pw)) {
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
				loop = true;
			} else {
				userSignOut(pw);
				System.out.println("회원탈퇴가 완료되었습니다.");
				loop = false;
			}
			
		}
		
	}

	
	private void userSignOut(String pw) {
		Calendar c = Calendar.getInstance();
		String signOut = String.format("%tF", c);
		for(Member u : Data.memberList) {
			if (u.getPw().equals(pw)) {
				((User)u).setSignOut(signOut);
			}
		}
		
	}


	private String findPwById(String id) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getPw();
			}
		}
		return null;
		
	}

}
