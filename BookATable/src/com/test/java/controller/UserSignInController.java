package com.test.java.controller;

import com.test.java.model.User;
import com.test.java.view.UserSignInView;

public class UserSignInController {

	public static boolean signIn() {
		
		String name = UserSignInView.getName();
		String jumin = UserSignInView.getJumin();
		String phone = UserSignInView.getPhoneNumber();
		String account = UserSignInView.getAccount();
		String id = UserSignInView.getId();
		String pw = UserSignInView.getPw();
		
		
		User user = new User(id,pw,name,phone,jumin,0,0,account,null);
		
//		//유효성 검사
//		if(isValid(user)) {
//			return true;
//		}
		
		return false;
	}

}
