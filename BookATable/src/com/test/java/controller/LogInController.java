package com.test.java.controller;

import java.io.BufferedReader;
import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.LogInView;
import com.test.java.view.View;

public class LogInController {

	public void logIn() {

		boolean loop = true;

		while (loop) {

			ArrayList<String> input = LogInView.getInput();
			String inputId = input.get(0);
			String inputPw = input.get(1);

//			if (checkInputId(inputId) == null) {
//				System.out.println("해당 아이디를 찾을 수 없습니다.");
//				View.pause();
//				continue;
//			}	
//			if (checkInputPw(inputId,inputPw) == null ) {
//				System.out.println("비밀번호가 맞지 않습니다.");
//				View.pause();
//				continue;
//			} else {
//				System.out.printf("");
//				loop = false;
//			}
			
			System.out.println(checkLogIn(inputId, inputPw)); 
			View.pause();   

		}

	}

	private String checkLogIn(String inputId, String inputPw) {
		String result = "";
		for (Member u : Data.memberList) {
			if (inputId.equals(u.getId())) {
				if (!inputPw.equals(u.getPw())) {
				result = "입력한 비밀번호가 올바르지 않습니다.";
				return result;
				} else {
					result = u.getName() + "님, 로그인에 성공하셨습니다.";
					Member.level = u.getUserType();
					return result;
				}
			} 
		}

		result = "해당 아이디를 찾을 수 없습니다.";
		return result;
	}

//	private String checkInputPw(String inputId, String inputPw) {
//
//		for (Member u : Data.memberList) {
//
//			if (inputPw.equals(u.getPw()) && inputId.equals(u.getId())) {
//				return u.getName();
//			}
//		}
//
//		return null;
//	}
//
//	private String checkInputId(String inputId) {
//
//		for (Member u : Data.memberList) {
//
//			if (inputId.equals(u.getId())) {
//				return u.getName();
//			}
//		}
//
//		return null;
//	}

}
