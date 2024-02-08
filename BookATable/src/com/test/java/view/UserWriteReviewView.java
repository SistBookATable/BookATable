package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Reservation;

public class UserWriteReviewView {

	public static void showNoReviewMessage() {
		System.out.println();
		System.out.println("리뷰를 작성하지 않은 예약이 없습니다.");
		System.out.println();
		View.pause();
	}

	public static void showNoReviewReservation(String userName) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("|                 %s님 리뷰 미작성 예약              	  <\n", userName);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		

		System.out.println("===========================================================================================");
		String header = String.format("%-13s%-10s%10s\t\t\t%10s\t\t%10s\t\t%10s\t\t%10s\t"
									,"[예약번호]","[예약일]","[상호명]","[인원수]","[예약취소여부]","[노쇼여부]","[리뷰작성여부]");
		System.out.println(header);
		
	}

	public static void showOneReserVation(Reservation r, String storeName) {
		String tmp = "";
		tmp = String.format("%10s\t%10s\t%10st%10st%10s\t%10s\t"
							, r.getReservationDate()
							, storeName
							, r.getNumOfPeople());
		System.out.println(tmp);
	}

	public static int getStoreName() {
		Scanner scan = new Scanner(System.in);
		System.out.print("리뷰 작성을 원하는 리뷰번호 입력해주세요: ");
		return View.getSelectType();
	}

	public static String getReviewContent() {
		Scanner scan = new Scanner(System.in);
		System.out.print("리뷰 작성란: ");
		return scan.nextLine();
	}

	public static void incorrectReservationNumber() {
		System.out.println();
		System.out.println("유효한 예약번호가 아닙니다.");
		System.out.println("리스트에 존재하는 예약번호를 입력해주세요.");
		System.out.println();
		View.pause();
	}

	public static void alreadyHasReview() {
		System.out.println();
		System.out.println("이미 작성한 리뷰가 존재합니다.");
		System.out.println();
		View.pause();
	}

	public static double getScore() {
		Scanner scan = new Scanner(System.in);
		System.out.print("점수 (소수 첫째자리): ");
		return Double.parseDouble(scan.nextLine());
	}

}
