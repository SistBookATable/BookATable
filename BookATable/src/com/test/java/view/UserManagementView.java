package com.test.java.view;

import java.util.Scanner;

public class UserManagementView {

	public void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 가입 회원 조회         \t■");
		System.out.println("■           2. 탈퇴 회원 조회         \t■");
		System.out.println("■           0. 이전 화면	          \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
		
	}

	public int getSelectType() {
		return View.getSelectType();
	}

	public void showTitle() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|             회원 관리 - 조회할 항목을 선택해주세요             	|");
		System.out.println("└───────────────────────────────────────────────────────┘");
	}

	public void incorrectInputMessgae() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("    (1, 2, 0) 중에 하나를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}

}
