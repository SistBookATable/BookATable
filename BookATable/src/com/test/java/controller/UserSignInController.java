package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.UserSignInView;

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
		
		
		User user = new User(id,pw,name,phone,jumin,0,0,null,account,null,null);
		
//		//유효성 검사
//		if(isValid(user)) {
//			return true;
//		}
		
		Data.memberList.add(user);
		for(Member u : Data.memberList) {
			System.out.println(u);
		}
		
		return true;
	}

}
