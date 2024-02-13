package com.test.java.view;

import java.util.Scanner;

public class BusinessUserMyPageView {


	public void showTitle() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                    업체 회원 - MyPage                 	|");
		System.out.println("└───────────────────────────────────────────────────────┘");
	}

	public void showSelectBox() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■            1. 예약 관리          \t■");
		System.out.println("■            2. 수익 관리          \t■");
		System.out.println("■            3. 영업 관리          \t■");
		System.out.println("■            4. 운영정보 관리       \t■");
		System.out.println("■            5. 문의 사항          \t■");
		System.out.println("■            6. 회원 탈퇴          \t■");
		System.out.println("■            0. 이전 화면	         \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
	}

	public int getSelectType() {
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		scan.nextLine();
		return tmp;
	}

	public int getSelect() {
		try {
			Scanner scan = new Scanner(System.in);
			int tmp = scan.nextInt();
			scan.nextLine();
			return tmp;
		} catch (Exception e) {
			return -1;
		}

	}

}
