package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Reservation;

public class UserWriteReviewView {

	public static void showNoReviewMessage() {
		System.out.println();
		System.out.println("리뷰가 작성되지 않은 예약이 없습니다.");
		System.out.println();
		View.pause();
	}

	public static void showNoReviewReservation(String userName) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("|                 %s님 리뷰 미작성 예약 리스트              	  <\n", userName);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%10s\t%10s\t%10s\t%10s\t%10s\t%10s\t%10s\t"
				,"[예약번호]","[예약일]","[상호명]","[인원수]","[예약취소여부]","[노쇼여부]","[리뷰작성여부]");

		System.out.println(header);
		
	}

	public static void showOneReserVation(Reservation r, String storeName, String cancelState, String noShowState, String reviewState) {
		String tmp = "";
		tmp = String.format("%10s\t%10s\t%10s\t%10s\t%10s\t%10s\t%10s\t"
							, String.valueOf(r.getReservationNumber())
							, r.getReservationDate()
							, storeName
							, r.getNumOfPeople() + "명"
							, cancelState
							, noShowState
							, reviewState);
		System.out.println(tmp);
	}

	public static int getReservationNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.print("리뷰 작성을 원하는 예약번호를 입력해주세요: ");
		int reservationNumber = scan.nextInt();
		scan.nextLine();
		return reservationNumber;
	}

	public static String getReviewContent() {
		Scanner scan = new Scanner(System.in);
		System.out.print("리뷰 작성란: ");
		return scan.nextLine();
	}

	public static double getReviewScore() {
		Scanner scan = new Scanner(System.in);
		System.out.print("별점: ");
		double tmp = scan.nextDouble();
		scan.nextLine();
		return tmp;
	}

}
