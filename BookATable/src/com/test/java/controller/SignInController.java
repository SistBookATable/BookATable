package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.User;
import com.test.java.view.SignInView;

public class SignInController {

	public void start() {
		ArrayList<String> inputList = new ArrayList<>();
		inputList = SignInView.getInput();
		String name = inputList.get(0);
		String jumin = inputList.get(1);
		String phone = inputList.get(2);
		String account = inputList.get(3);
		String id = inputList.get(4);
		String pw = inputList.get(5);
		
		
		User user = new User(id,pw,name,phone,jumin,0,0,account,null);
		
		
		
	}

}
