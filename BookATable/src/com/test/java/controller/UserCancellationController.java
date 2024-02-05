package com.test.java.controller;

import java.util.Iterator;

import com.test.java.model.Member;
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
				userCancellation(Member.id);
				System.out.println("회원탈퇴가 완료되었습니다.");
				Member.level = 0;
				loop = false;
			}
			
		}
		
	}

	private void userCancellation(String id) {
	    Iterator<Member> iterator = Data.memberList.iterator();

	    while (iterator.hasNext()) {
	        Member u = iterator.next();
	        if (u.getId().equals(id) && u.getUserType() == 1) {
				iterator.remove();
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
