package com.test.java.view;

import com.test.java.model.Member;
import com.test.java.repository.Data;

public class SignInUserManagementView {

	public static void showSignInUser() {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                  회원 관리 - 가입 회원 조회                 ■");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		System.out.println("[회원ID]\t[가입일]\t[회원 이름]\t[예약 횟수]\t[노쇼 횟수]\t[정지 여부]");
		
		for(Member m : Data.memberList) {
			String tmp = "";
			String.format("%s\t%s\t%s\t%s\t%s\t%s\t");
		}
	}

}
