package com.test.java.view;

import java.util.Scanner;

public class InquiryCompletedReservationView {

	public void showInquiryCompletedReservation(String userName, String reserveDate, String storeName, int numOfPeple,
			String canceledReservationState, String noShowState, String reviewState) {
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 현재 예약 현황		   ■", userName);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");

		System.out.println();
		System.out.printf("[예약일]\t[상호명]\t[인원수]\t[예약 취소]\t[노쇼]\t[리뷰 작성]\n");
		System.out.printf("[%s]\t[%s]\t[%d명]\t[%s]\t[%s]\t[%s]\n"
						 , reserveDate, storeName, numOfPeple, canceledReservationState, noShowState, reviewState);

		System.out.println();
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■           1. 리뷰 작성하기	   ■");
		System.out.println("■           0. 이전 화면		   ■");
		System.out.println();
		System.out
				.println("------------------------------------------------------------------------------------------");

		System.out.println();

		System.out.print("선택(번호) : ");
		System.out.println();
	}

	public int get() {
		Scanner scan = new Scanner(System.in);
		
		return 0;
	}
}