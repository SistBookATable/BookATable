package com.test.java.view;

import java.util.Scanner;

public class UpdateAccountView {

	public static String getAccount() {
		System.out.print("새 계좌번호 입력: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}

	public static void showUpdateAccount(String toUpdateAccount) {
		System.out.printf("변경할 출금계좌가 [%s]가 맞습니까?\n", toUpdateAccount);
	}

	public static String getAnswer() {
		System.out.print("입력 (Y/N): ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}

}
