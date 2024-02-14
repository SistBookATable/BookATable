package com.test.java.view;

import java.util.Scanner;

/**
 * 사용자 마이페이지를 표시하고 사용자의 입력을 처리하는 뷰(View) 클래스입니다.
 */
public class UserMyPageView {
	
	 /**
     * 사용자 마이페이지를 화면에 표시하는 메서드입니다.
     */
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
	
	/**
     * 사용자의 입력을 받아 반환하는 메서드입니다.
     * @return 사용자가 입력한 정수값
     */
	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		
		return temp;
	}

	


}
