package com.test.java.view;

import java.util.Scanner;

public class UserMyPageView {
	
	public static void showUserMyPage() {
		
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|              My Page - 원하시는 항목을 선택해주세요          	|");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println();
		System.out.println("■           1. 예약 관리			   ■");
		System.out.println("■           2. 포인트 관리			   ■");
		System.out.println("■           3. 관심매장 관리		   ■");
		System.out.println("■           4. 개인정보 관리		   ■");
		System.out.println("■           5. 회원탈퇴			   ■");
		System.out.println("■           6. FAQ			   ■");
		System.out.println("■           0. 이전 화면으로 돌아가기		   ■");
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
