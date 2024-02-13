package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Reservation;
/**
 * InquiryCompletedReservationView 클래스는 일반회원의 이용이 완료된 예약내역을 출력합니다.
 * 또한, 이용이 완료된 건에 대하여 상호명 입력 후에 리뷰작성 화면으로 이동할 수 있습니다.
 */
public class InquiryCompletedReservationView {

	 /**
     * 이용 완료된 예약내역의 메인 화면을 출력하는 메서드입니다.
     * @param userName 사용자 이름
     */
	public static void showTitle(String userName) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("|                 %s님 이용 완료 예약 조회          	  <\n", userName);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		System.out.println("===========================================================================================================");
		String header = String.format("%-10s\t%-10s\t%-10s\t\t%-10s\t\t%-10s\t\t%-10s\t\t%-10s\t"
									,"[예약번호]", "[예약일]","[상호명]","[인원수]","[예약취소여부]","[노쇼여부]","[리뷰작성여부]");
		System.out.println(header);
	}
	
	/**
     * 하나의 예약 정보를 출력합니다.
     * @param r 예약 객체
     * @param storeName 상호명
     * @param cancelState 예약 취소 여부
     * @param noShowState 노쇼 여부
     * @param reviewState 리뷰 작성 여부
     */
	public static void showOneReservation(Reservation r, String storeName, String cancelState, String noShowState, String reviewState) {
		String tmp = "";
		tmp = String.format("%-10d\t%-10s\t%-10s\t\t%-10s\t\t%-10s\t\t%-10s\t\t%-10s\t"
							, r.getReservationNumber()
							, r.getReservationDate()
							, storeName
							, r.getNumOfPeople() +"명"
							, cancelState
							, noShowState
							, reviewState);
		System.out.println(tmp);
	}
	
	
	/**
     * 선택 옵션을 출력하는 메서드입니다.
     */
	public static void showSelecBox() {
		System.out.println("===========================================================================================================");
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■         		  1. 리뷰 작성		   \t■");
		System.out.println("■         		  0. 이전 화면		   \t■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.print("선택(번호) : ");
		
	}
	
	/**
     * 사용자가 선택한 번호를 반환하는 메서드입니다.
     * @return 선택 번호
     */
	public static int get() {
		return View.getSelectType();
	}

	/**
     * 리뷰를 작성할 음식점 이름을 입력 받는 메서드입니다.
     * @return 상호명
     */
	public static String inputStoreName() {
		System.out.println("리뷰작성을 원하는 음식점을 입력해주세요.");
		System.out.print("상호명: ");
		Scanner scan = new Scanner(System.in);
		String storNameToWriteReview = scan.nextLine();
		return storNameToWriteReview;
	}

	/**
     * 방문 내역이 없는 경우에 메시지를 출력하는 메서드입니다.
     */
	public static void showNoVisitationMessage() {
		System.out.println();
		System.out.println("방문 내역이 없습니다.");
		System.out.println();
		View.pause();
	}


}