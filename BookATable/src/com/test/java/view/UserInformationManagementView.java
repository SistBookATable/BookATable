package com.test.java.view;

import java.util.Scanner;

public class UserInformationManagementView {

	public static void showTitle(String userName) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("|		%s 회원님	개인정보 조회		|\n", userName);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		System.out.println();
		
		
	}

	public static void showUserInformation(String userName, String id, String phoneNumber, String birthDate, String account, String balance) {
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println();
		String header = String.format("%-5s\t%-15s\t%-13s\t%-6s\t\t%-16s\t%s", "[이름]","[ID]","[전화번호]","[생년월일]", "[계좌]", "[잔액]");
		System.out.println(header);
		String body = String.format("%-5s\t%-15s\t%-13s\t%-6s\t\t%-16s\t%s원", userName, id, phoneNumber, birthDate, account, balance);
		System.out.println(body);
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------");
	}

	public static void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 개인정보 수정	  ■");
		System.out.println("■           0. 이전 화면		  ■");
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
