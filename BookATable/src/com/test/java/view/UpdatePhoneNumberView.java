package com.test.java.view;

import java.util.Scanner;

public class UpdatePhoneNumberView {

	public static String getPhoneNumber() {
		System.out.print("변경할 전화번호 입력: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}

	public static void showUpdatePhoneNumber(String toUpdatePhoneNumber) {
		System.out.printf("변경할 전화번호가 [%s]가 맞습니까?\n", toUpdatePhoneNumber);
	}

	public static String getAnswer() {
		System.out.print("입력 (Y/N): ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}

}
