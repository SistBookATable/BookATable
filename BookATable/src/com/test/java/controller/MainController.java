package com.test.java.controller;

import com.test.java.view.MainView;

public class MainController {

	/**
	 * 메인 화면 시작 
	 */
	public static void start() {
		
		MainView.logo();
		MainView.show();
		int choice = MainView.get();
		
		switch(choice) {
		case 1:
			SignInController signInController = new SignInController();
			signInController.signIn();
			break;
		case 2:
			LogInController logInController = new LogInController();
			logInController.start();
			break;
		case 3:
			break;
		case 4:
			break;
		}
		
	}
}
