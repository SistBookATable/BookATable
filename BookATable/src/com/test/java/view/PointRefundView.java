package com.test.java.view;

import java.util.Scanner;

/**
 * 포인트 환불 관련 View 클래스입니다.
 */

public class PointRefundView {
	
	/**
	 * 포인트 환불 메뉴를 표시하는 메서드입니다.
	 */
	
	public static void showPointRefund() {
		System.out.println();
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 포인트 환불 신청		   ■");
		System.out.println("■           2. 환불 신청 내역		   ■");
		System.out.println("■           0. 이전 화면			   ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
	}
	
	/**
	 * 사용자로부터 선택을 입력받는 메서드입니다.
	 * @return 사용자의 선택
	 */
	
	public static int get() {
		
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		
		return temp;
	}
	
	/**
	 * 포인트 환불 완료 메시지 출력 메서드입니다.
	 */
	
	public void showRefund() {
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("환불 신청이 완료되었습니다.");
		System.out.println("신청일 기준 영업일 1~2일 내 해당 계좌로 입금됩니다.");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println();
		
		View.pause();
	}

}
