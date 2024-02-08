package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.User;
import com.test.java.view.SignInView;


public class SignInController {

	SignInView signInView = new SignInView();
	/**
	 * 회원 가입 기능
	 */	
	public void signIn() {
		
		boolean loop = true;
		while(loop) {
			signInView.showSelectType();
			int choice = signInView.getSelectType();
			
			
			switch(choice) {
			case 1:
				//일반회원 회원가입
				loop = !(UserSignInController.signIn());
				break;
			case 2:
				//업체회원 회원가입
				loop = !(BusinessUserSignInController.signIn());
				break;
			case 0:
				loop = false;
				break;
			default:
				//유효하지 않은 입력
				signInView.incorrectInputMessage();
			}
		}
		
			
	}

}
