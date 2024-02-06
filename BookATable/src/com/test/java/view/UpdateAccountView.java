package com.test.java.view;

import java.util.Scanner;

public class UpdateAccountView {

	public static String getBank() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("사용계좌 은행을 선택해 주세요");
		System.out.println("1. SC제일은행");
		System.out.println("2. 신한은행");
		System.out.println("3. 씨티은행");
		System.out.println("4. DGB대구은행");
		System.out.println("5. 케이뱅크");
		System.out.println("6. NH농협은행");
		System.out.println("7. 우리은행");
		System.out.println("8. 부산은행");
		System.out.println("9. 카카오뱅크");
		System.out.println("10. IBK기업은행");
		System.out.println("11. KEB하나은행");
		System.out.print("입력 (번호) : ");
		tmp = scan.nextLine();
		return tmp;
	}

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
