package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.LogInView;
import com.test.java.view.MainView;

public class LogInController {

	public void logIn() {
		boolean again = false;

		while (true) {
			if (again) {
				LogInView.showAgain();
				int choice = LogInView.get();
				if (choice == 1) {
				} else if (choice == 2) {
					break;
				}
			}

			ArrayList<String> input = LogInView.getInput();
			String id = input.get(0);
			String pw = input.get(1);
			again = true;

			boolean isValidId = checkId(id);
			if (isValidId == false) {
				System.out.println("해당 아이디를 찾을 수 없습니다.");
				continue;
			}

			boolean isValidPw = checkIdPw(id, pw);
			if (isValidPw == false) {
				System.out.println("해당 아이디는 등록되어있으나, 비밀번호가 일치하지 않습니다.");
				continue;
			}

			System.out.printf("%s님, 로그인에 성공하셨습니다.", findNameById(Member.id));
			break;
		}

	}

	private String findNameById(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id) && u.getSignOut().equals("null")) {
				return u.getName();
			}
		}
		return null;
	}

	private boolean checkIdPw(String id, String pw) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				if (u.getPw().equals(pw)) {
					Member.level = u.getUserType();
					Member.id = u.getId();
					return true;

				}
			}
		}
		return false;
	}

	private boolean checkId(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
}
