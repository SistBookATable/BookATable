package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.LogInView;
import com.test.java.view.MainView;
import com.test.java.view.View;

public class LogInController {
	LogInView logInView = new LogInView();

	public void logIn() {
		
		boolean loop = true;

		while (loop) {

			ArrayList<String> input = LogInView.getInput();
			String inputId = input.get(0);
			String inputPw = input.get(1);

			loop = !checkLogIn(inputId, inputPw);
			
			View.pause();   

		}

	}

	private boolean checkLogIn(String inputId, String inputPw) {
		String result = "";
		for (Member u : Data.memberList) {
			if (inputId.equals(u.getId())) {
				if (!inputPw.equals(u.getPw())) {
				System.out.println("입력한 비밀번호가 올바르지 않습니다.");
				return false;
				} else {
					System.out.println(u.getName() + "님, 로그인에 성공하셨습니다.");
					Member.level = u.getUserType();
					findNameById(Member.id);
					return true;
				}
			} 
			
		}
		System.out.println("해당 아이디를 찾을 수 없습니다.");
		logInView.show();
		if (logInView.get()==1) {
			return false;
		} else {
			return true;
		}
	}
		
		

	private String findNameById(String id) {
		String name = "";
		
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				name = u.getName();
				break;
			}
		}
		return name;
		
	}

}
