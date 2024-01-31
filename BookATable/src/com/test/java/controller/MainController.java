package com.test.java.controller;

import com.test.java.view.MainView;
import com.test.java.view.StoreView;

public class MainController {

	/**
	 * 메인 화면 시작 
	 */
	public static void start() {
		
		
<<<<<<< HEAD
		switch(choice) {
		case 1:
			SignInController signInController = new SignInController();
			signInController.signIn();
			break;
		case 2:
			LogInController logInController = new LogInController();
			logInController.logIn();
			break;
		case 3:
			break;
		case 4:
			break;
=======
		boolean loop = true;
		while(loop) {

			MainView.logo();
			MainView.show();
			int choice = MainView.get();
			
			switch(choice) {
			case 1:
				SignInController signInController = new SignInController();
				signInController.signIn();
				break;
			case 2:
				//LogInController logInController = new LogInController();
				//logInController.logIn();
				break;
			case 3:
				FindAccountController findAccountController = new FindAccountController();
				findAccountController.findAccount();
				break;
			case 4:
				break;
			default:
				loop = false;
			}
>>>>>>> 957e6d320bff1c51c7ac78514fbe2a611a62d14b
		}
	}
	
	private static void searchMenu() {
		StoreView storeView = new StoreView();
		storeView.searchMenu();
	
		
	}
}
