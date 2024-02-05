package com.test.java.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.UpdatePwView;

public class UpdatePwController {

	public void updatePw() {
		
		boolean loop = true;
		while(loop) {
			String toUpdatePw = UpdatePwView.getPw();
		
			if (!isVaildOfPw(toUpdatePw)) {
				System.err.println("PW는 특수문자(!,@,#,$,%,^,&,*)를 1자 이상 포함하는 5자로 작성하십시오");
				loop = true;
			} else {
				updatePwToInputPW(Member.id, toUpdatePw);
				System.out.println(toUpdatePw);
				System.out.println("비밀번호가 변경되었습니다.");
				loop = false;
			}
		}
	}

	private boolean isVaildOfPw(String toUpdatePw) {
		String regex = "^(?=.*[!@#$%^&*]).{5,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(toUpdatePw);
		return matcher.matches();
	}

	private void updatePwToInputPW(String id, String toUpdatePw) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				((User)u).setPw(toUpdatePw);
			}
		}
		
	}


}
