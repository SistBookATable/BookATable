package com.test.java.view;

import java.util.Calendar;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Review;
import com.test.java.repository.Data;

public class InquiryCompletedReservationView {

	public static void showInquiryCompletedReservation(String userName, String reserveDate, String storeName, int numOfPeple,
			String canceledReservationState, String noShowState, String reviewState) {
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 현재 예약 현황		   ■", userName);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");

		System.out.println();
		System.out.printf("[예약일]\t[상호명]\t[인원수]\t[예약 취소]\t[노쇼]\t[리뷰 작성]\n");
		System.out.printf("[%s]\t[%s]\t[%d명]\t[%s]\t\t[%s]\t[%s]\n"
						 , reserveDate, storeName, numOfPeple, canceledReservationState, noShowState, reviewState);

		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■           1. 리뷰 작성하기	   ■");
		System.out.println("■           0. 이전 화면		   ■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");

		System.out.println();

		System.out.print("선택(번호) : ");
		System.out.println();
	}

	public static int get() {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}

	public static String inputStoreName() {
		System.out.println("리뷰작성을 원하는 음식점을 입력해주세요.");
		System.out.print("상호명: ");
		Scanner scan = new Scanner(System.in);
		String storNameToWriteReview = scan.nextLine();
		return storNameToWriteReview;
	}

	public static String writeReview() {
		System.out.print("리뷰 작성란: ");
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
}