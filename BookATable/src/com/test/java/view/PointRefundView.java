package com.test.java.view;

import java.util.Scanner;

public class PointRefundView {
	
	
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
	
	public static int get() {
		
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		
		return temp;
	}
	
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
