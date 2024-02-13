package com.test.java.view;

import java.util.Scanner;

public class UserCancellationView {

	public static void show() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|    	    	회원탈퇴 - 비밀번호를 입력해주세요		|");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
	}

	public static String getPw() {
		System.out.print("비밀번호 입력: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
		
	}

}
