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
			signInController.start();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
		
	}
}
