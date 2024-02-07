package com.test.java.controller;

import com.test.java.view.SignInView;

public class SignInController {

<<<<<<< HEAD
=======
	SignInView signInView = new SignInView();
>>>>>>> 91198df03630dfaa153a2f9863fa25cb8e98c035
	/**
	 * 회원 가입 기능
	 */	
	public void signIn() {
		
		boolean loop = true;
		while(loop) {
			signInView.showSelectType();
			String choice = signInView.getSelectType();
			
			switch(choice) {
			case "1":
				//일반회원 회원가입
				loop = !(UserSignInController.signIn());
				break;
			case "2":
				//업체회원 회원가입
				loop = !(BusinessUserSignInController.signIn());
				break;
			case "0":
				loop = false;
				break;
			default:
				//유효하지 않은 입력
				signInView.incorrectInputMessage();
			}
		}
		
			
	}

}
