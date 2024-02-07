package com.test.java.view;

import java.util.Scanner;

public class UpdatePwView {

	public static String getPw() {
		System.out.print("변경할 비밀번호 입력: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}

	public static void showErrorMessage() {
		System.out.println();
		System.out.println("PW는 특수문자(!,@,#,$,%,^,&,*)를 1자 이상 포함하는 5자로 작성하십시오");
		System.out.println();
		View.pause();
	}

	public static void showUpdatePwMessage() {
		System.out.println();
		System.out.println("비밀번호가 변경되었습니다.");
		System.out.println();
		View.pause();
	}

}
