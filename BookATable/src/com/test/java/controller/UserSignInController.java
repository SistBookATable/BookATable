package com.test.java.controller;

import java.util.Calendar;
import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.UserSignInView;
import com.test.java.view.View;


public class UserSignInController {

	/**
	 * @return boolean
	 * 일반회원 회원가입이 완료되면 true
	 * 가입이 중단되면 false
	 */
	public static boolean signIn() {
		
		String name = UserSignInView.getName();
		String jumin = UserSignInView.getJumin();
		String phone = UserSignInView.getPhoneNumber();
		String account = UserSignInView.getAccount();
		String id = UserSignInView.getId();
		String pw = UserSignInView.getPw();
		
		Calendar c = Calendar.getInstance();
		String now = String.format("%tF", c);
		
		User user = new User(id,pw,name,phone,jumin,0,0,0,"null",account,"null",now,"null");
		
//		//유효성 검사
//		if(isValid(user)) {
//			return true;
//		}
		
		
		System.out.println("회원가입이 완료되었습니다.");
		Data.memberList.add(user);
		for(Member u : Data.memberList) {
			System.out.println(u);
		}
		
		View.pause();
		
		return true;
	}

}
