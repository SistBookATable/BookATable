package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Reservation;

/**
 * UserWriteReviewView는 사용자 리뷰 작성과 관련된 화면 출력을 담당하는 클래스입니다.
 */
public class UserWriteReviewView {
	
	/**
     * 리뷰가 작성되지 않은 예약이 없을 때 출력하는 메서드입니다.
     */
	public static void showNoReviewMessage() {
		System.out.println();
		System.out.println("리뷰가 작성되지 않은 예약이 없습니다.");
		System.out.println();
		View.pause();
	}

	/**
     * 리뷰 미작성 예약 리스트를 출력하는 메서드입니다.
     * @param userName 사용자 이름
     */
	public static void showNoReviewReservation(String userName) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("|                 %s님 리뷰 미작성 예약 리스트              	  <\n", userName);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%10s\t%10s\t%10s\t%10s\t%10s\t%10s\t%10s\t"
				,"[예약번호]","[예약일]","[상호명]","[인원수]","[예약취소여부]","[노쇼여부]","[리뷰작성여부]");

		System.out.println("===========================================================================================");
//		String header = String.format("%-13s%-10s%10s\t%10s\t"
//									,"[예약번호]","[예약일]","[상호명]","[인원수]");
		System.out.println(header);
	
	}

	 /**
     * 개별 예약 정보를 출력하는 메서드입니다.
     * @param r 예약 정보
     * @param storeName 상호명
     * @param cancelState 예약 취소 여부
     * @param noShowState 노쇼 여부
     * @param reviewState 리뷰 작성 여부
     */
	public static void showOneReserVation(Reservation r, String storeName, String cancelState, String noShowState, String reviewState) {
		String tmp = "";
		tmp = String.format("%d\t%10s\t%10s\t%10d\t"
							, r.getReservationNumber()
							, r.getReservationDate()
							, storeName
							, r.getNumOfPeople() + "명"
							, cancelState
							, noShowState
							, reviewState);
		System.out.println(tmp);
	}

	 /**
     * 사용자에게 리뷰 작성을 원하는 예약 번호를 입력받는 메서드입니다.
     * @return 입력받은 예약 번호
     */
	public static int getReservationNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.print("리뷰 작성을 원하는 예약번호를 입력해주세요: ");
		int reservationNumber = scan.nextInt();
		scan.nextLine();
		return reservationNumber;
	}

	/**
     * 사용자에게 리뷰 내용을 입력받는 메서드입니다.
     * @return 입력받은 리뷰 내용
     */
	public static String getReviewContent() {
		Scanner scan = new Scanner(System.in);
		System.out.print("리뷰 작성란: ");
		return scan.nextLine();
	}

	/**
     * 사용자에게 별점을 입력받는 메서드입니다.
     * @return 입력받은 별점
     */
	public static double getReviewScore() {
		Scanner scan = new Scanner(System.in);
		System.out.print("별점: ");
		double tmp = scan.nextDouble();
		scan.nextLine();
		return tmp;
	}

	/**
     * 잘못된 예약 번호를 입력했을 때 출력하는 메서드입니다.
     */
	public static void incorrectReservationNumber() {
		 System.out.println("유효한 예약 번호가 아닙니다.");
		
	}

	 /**
     * 이미 리뷰를 작성한 예약 번호를 입력했을 때 출력하는 메서드입니다.
     */
	public static void alreadyHasReview() {
		System.out.println("이미 리뷰를 작성한 예약입니다.");
		
	}

	 /**
     * 리뷰 작성이 완료되었음을 알리는 메서드입니다.
     */
	public static void showCompleteMessage() {
		System.out.println("리뷰 작성이 완료되었습니다.");
	}

}
