package com.test.java.view;

import java.util.Scanner;

public class ReservationStatusInquiryView {
	
	
	public void showReservationStatusInquiry(String name) {

		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 현재 예약 현황		   ■\n", name);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");

		System.out.println();

		System.out.printf("[상호명]\t[인원수]\t[예약 시간]\n");
		System.out.printf("맥도날드\t3명\t13:00\t\n");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■           1. 예약 취소		   ■");
		System.out.println("■           0. 이전 화면		   ■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.print("선택(번호) : ");
		System.out.println();
	}

	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		
		return temp;
	}
	
	

}
