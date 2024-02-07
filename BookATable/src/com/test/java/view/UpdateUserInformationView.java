package com.test.java.view;

import java.util.Scanner;

public class UpdateUserInformationView {

	public static void show() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|        개인정보 수정 - 원하시는 항목을 선택해주세요				<");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
	}

	public static void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 비밀번호 변경                  ■");
		System.out.println("■           2. 출금계좌 변경                  ■");
		System.out.println("■           3. 전화번호 변경                  ■");
		System.out.println("■           0. 뒤로 가기                     ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
		
	}

	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		return temp;
	}

	public static String getPw() {
		System.out.print("비밀번호 입력: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}

	public static void showErrorMessage() {
		System.out.println();
		System.out.println("비밀번호를 잘못 입력하셨습니다.");
		System.out.println();
		View.pause();
	}

}
