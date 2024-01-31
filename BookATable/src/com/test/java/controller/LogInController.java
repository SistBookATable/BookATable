package com.test.java.controller;

import java.io.BufferedReader;
import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.LogInView;

public class LogInController {
	
	public void logIn() {
		
		boolean loop = true;
		
		while(loop) {
			
			ArrayList<String> input = LogInView.getInput();
			String inputId = input.get(0);
			String inputPw = input.get(1);
			
			if (!checkInputId(inputId)) {
				System.out.println("해당 ID를 찾을 수 없습니다.");
				loop = true;
			} else {
				loop = false;
			}
			
		}
		
	}

	private boolean checkInputId(String inputId) {
		
		for(Member u : Data.memberList) {
			System.out.println(u.getId());
			
			if (inputId.equals(u.getId())) {
				return true;
			}
		}
		
		return false;
	}
}
     