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

		while (loop) {

			ArrayList<String> input = LogInView.getInput();
			String inputId = input.get(0);
			String inputPw = input.get(1);

			if (checkInputId(inputId) == null) {
				System.out.println("해당 아이디를 찾을 수 없습니다.");
				loop = true;
			} else {
				if (checkInputPw(inputPw) == null ) {
					System.out.println("비밀번호가 맞지 않습니다.");
				}
			}

			System.out.println("등록된 아이디입니다.");
			loop = false;
		}

	}

	private String checkInputPw(String inputPw) {

		for (Member u : Data.memberList) {

			if (inputPw.equals(u.getPw())) {
				return u.getName();
			}
		}

		return null;
	}

	private String checkInputId(String inputId) {

		for (Member u : Data.memberList) {

			if (inputId.equals(u.getId())) {
				return u.getName();
			}
		}

		return null;
	}

}
