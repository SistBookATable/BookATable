package com.test.java.view;

import java.util.Scanner;

public class UpdatePwView {

	public static String getPw() {
		System.out.print("변경할 비밀번호 입력: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}

}
