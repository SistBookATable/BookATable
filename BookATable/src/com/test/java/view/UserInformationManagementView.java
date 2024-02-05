package com.test.java.view;

import java.util.Scanner;

public class UserInformationManagementView {

	public static void showUserInformation(String name, String id, String phoneNumber, String birth, String account,
			int balance) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("			%s 회원님	개인정보 조회			\n", name);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println("[이름]\t[ID]\t[전화번호]\t\t[생년월일]\t\t[계좌]\t[잔액]\n");
		System.out.printf("[%s]\t[%s]\t[%s]\t\t[%s]\t\t[%s]\t[%d]\n", name, id, phoneNumber, birth, account, balance);
	}

	public static void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 개인정보 수정		   ■");
		System.out.println("■           0. 이전 화면			   ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
	}

	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		return temp;
	}

}
