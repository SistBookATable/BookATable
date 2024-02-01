package com.test.java.view;

import java.util.Scanner;

public class ReservationManagementView {

	public static void showReservationManagement() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|              예약 관리 - 원하시는 항목을 선택해주세요          	|");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 예약 현황 조회		   ■");
		System.out.println("■           2. 이용완료 내역 조회	   	   ■");
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
