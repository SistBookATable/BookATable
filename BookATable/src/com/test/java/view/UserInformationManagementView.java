package com.test.java.view;

public class UserInformationManagementView {

	public static void showUserInformation(String name, String id, String phoneNumber, String birth) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("			%s 회원님	개인정보 조회			\n", name); 
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println("[이름]\t[ID]\t[전화번호]\t[생년월일]\t[계좌]\t[잔액]\n");
		System.out.printf("[%s]\t[ID]\t[전화번호]\t[생년월일]\t[계좌]\t[잔액]\n"
				, name, id, phoneNumber );
		
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 개인정보 수정		   ■");
		System.out.println("■           0. 이전 화면			   ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");

	}

}
