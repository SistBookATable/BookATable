package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Reservation;
import com.test.java.repository.Data;

/**
 * 포인트 환불 내역 조회를 담당하는 View 클래스입니다.
 */
public class PointRefundHistoryView {
	
	/**
	 * 환불 신청 내역을 출력하는 메서드입니다. 
	 * @param userName 사용자 이름
	 * @param refundDate 환불 신청일
	 * @param pointAmount  환불 포인트 금액
	 */
	public static void showPointRefundHistory(String userName, String refundDate, int pointAmount) {

		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 환불 신청 내역		   ■", userName);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");

		System.out.println();
		System.out.println("[환불신청일] : " + refundDate);
		System.out.println("[포인트금액] : " + pointAmount);

		
	}
	
	/**
	 * 사용자로부터 환불여부를 입력 받는 메서드입니다. 
	 * @return 사용자가 입력한 문자열
	 */
	public String get() {
		
		Scanner scan = new Scanner(System.in);
	
		String temp = scan.nextLine();
		return temp;
	}

	/**
	 * 포인트 환불 내역이 없을 때  출력하는 메서드입니다.
	 */
	public void noHistoryMessage() {

		System.out.println();
		System.out.println("■           포인트 환불내역이 없습니다.		   ■");
		System.out.println();
		View.pause();
		
	}

	/**
	 * 환불 신청이 성공적으로 취소되었음을 출력하는 메서드입니다.
	 */
	public void successMessage() {

		System.out.println();
		System.out.println("■           환불 신청이 취소되었습니다.		   ■");
		System.out.println();
		View.pause();
	}

	/**
	 * 환불 취소 과정이 중지되었음을 출력하는 메서드입니다.
	 */
	public void cancelMessage() {

		System.out.println();
		System.out.println("■           환불 취소 과정을 중지합니다.		   ■");
		System.out.println();
		View.pause();
	}

	/**
	 * 잘못된 입력이 있음을 알리는 메서드입니다. 
	 */
	public void incorrectInputMessage() {
		System.out.println();
		System.out.println("■              잘못된 입력입니다.      		   ■");
		System.out.println();
		View.pause();
	}

	/**
	 * 환불 취소가 불가능한 경우 표시되는 메서드입니다.
	 */
	public void cannotCancelMessage() {
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■        계좌로 지급이 완료되어 환불 취소가 불가능합니다.	   ■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		View.pause();
		
	}

	/**
	 * 환불 취소 여부를 입력하도록 안내하는 메서드입니다. 
	 */
	public void showSelectBox() {
		
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■           환불 취소하시겠습니까? (Y/N)		   ■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.print("입력(Y/N) : ");
	}


}
