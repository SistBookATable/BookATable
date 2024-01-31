package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.User;
import com.test.java.view.SignInView;


public class SignInController {

	
	/**
	 * 회원 가입 기능
	 */	
	public void signIn() {
		
		boolean loop = true;
		while(loop) {
			SignInView.showSelectType();
			int choice = SignInView.getSelectType();
			
//			유효성 검사
//			if(!isValid(choice)) {
//				continue;
//			}
			
			switch(choice) {
			case 1:
				loop = !(UserSignInController.signIn());
				break;
			case 2:
				loop = !(BusinessUserSignInController.signIn());
				break;
			case 0:
				return;
			}
		}
		
			
	}

}
