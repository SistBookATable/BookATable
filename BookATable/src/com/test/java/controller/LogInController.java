package com.test.java.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Member;
import java.nio.file.Path;
import java.util.ArrayList;

import com.test.java.model.User;
import com.test.java.view.LogInView;

public class LogInController {

	public void logIn() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList = LogInView.getInput();
		
		User user = new User();
		
		if (user.getId().equals(inputList.get(0))) {
			
		}
		
		
	
	}
	
}
     