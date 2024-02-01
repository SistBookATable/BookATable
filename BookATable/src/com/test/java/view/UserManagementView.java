package com.test.java.view;

import java.util.Scanner;

public class UserManagementView {

	public static void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 가입 회원 조회              ■");
		System.out.println("■           2. 탈퇴 회원 조회              ■");
		System.out.println("■           0. 뒤로 가기                  ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
		
	}

	public static int getSelectType() {
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		scan.nextLine();
		return tmp;
	}

	public static void showTitle() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|             회원 관리 - 조회할 항목을 선택해주세요              ■");
		System.out.println("└───────────────────────────────────────────────────────┘");
	}

}
