package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Reservation;

public class InquiryCompletedReservationView {

	public static void showTitle(String userName) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("|                 %s님 이용 완료 예약 조회          	  <\n", userName);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		System.out.println("===========================================================================================");
		String header = String.format("%10s\t\t%10s\t\t%10s\t\t%10s\t\t%10s\t\t%10s\t"
									,"[예약일]","[상호명]","[인원수]","[예약취소여부]","[노쇼여부]","[리뷰작성여부]");
		System.out.println(header);
	}
	
	public static void showOneReservation(Reservation r, String storeName, String cancelState, String noShowState, String reviewState) {
		String tmp = "";
		tmp = String.format("%10s\t\t%10s\t\t%10s\t\t%10s\t\t%10s\t\t%10s\t"
							, r.getReservationDate()
							, storeName
							, r.getNumOfPeople()
							, cancelState
							, noShowState
							, reviewState);
		System.out.println(tmp);
	}
	
	

	public static void showSelecBox() {
		System.out.println("===========================================================================================");
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■         		  1. 리뷰 작성		   ■");
		System.out.println("■         		  0. 이전 화면		   ■");
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

	public static void showNoVisitationMessage() {
		System.out.println();
		System.out.println("방문 내역이 없습니다.");
		System.out.println();
		View.pause();		
	}


}