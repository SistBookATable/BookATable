package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.view.LogInView;
import com.test.java.view.View;

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
			
			//전체 회원 리스트
			ArrayList<Member> memberList = MemberRepository.findAll();
			
			//전체 회원 리스트가 비어있으면
			if(memberList.isEmpty()) {
				System.out.println("해당 아이디를 찾을 수 없습니다.");
				continue;
			}
			
			//입력한 id로 회원 조회
			Member member = MemberRepository.findOneById(id);
			
			//조회한 회원이 null이면
			if(member==null || !member.getSignOut().equals("null")) {
				System.out.println("해당 아이디를 찾을 수 없습니다.");
				continue;
			}
			
			//회원의 비밀번호가 입력한 비밀번호와 다르면
			if(!member.getPw().equals(pw)) {
				System.out.println("해당 아이디는 등록되어있으나, 비밀번호가 일치하지 않습니다.");
				continue;
			}

			//로그인 성공
			Member.id = id;
			Member.level = member.getUserType();
			String name = member.getName();
			System.out.printf("%s님, 로그인에 성공하셨습니다.", name);
			break;
		}
		View.pause();

	}

}
