package com.test.java.view;

import java.util.Scanner;

public class UpdatePhoneNumberView {

	public static String getPhoneNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.print("변경할 전화번호 입력: ");
		return scan.nextLine();
	}
	
	public static void showErrorMessage() {
		System.out.println();
		System.out.println("전화번호를 숫자와 “-”로만 구성하여  [000-0000-0000] 형식으로 작성하십시오");
		System.out.println();
		View.pause();
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

	public static void showUpdateStopMessage() {
		System.out.println();
		System.out.println("전화번호 변경을 취소하겠습니다.");
		System.out.println("다시 입력해주시길 바랍니다.");
		System.out.println();
		View.pause();
	}

	public static void showUpdatePhoneNumberMessage() {
		System.out.println();
		System.out.println("전화번호가 변경되었습니다.");
		System.out.println();
		View.pause();
	}

}
