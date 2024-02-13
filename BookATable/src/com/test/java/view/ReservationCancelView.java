package com.test.java.view;

import java.util.Scanner;

/**
 * 예약 취소에 관련된 화면을 표시하는 뷰(View) 클래스입니다.
 */
public class ReservationCancelView {
	
	/**
     * 예약을 취소할지 여부를 묻는 화면을 표시하는 메서드입니다.
     */
	public static void showReservationCancel() {

		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("           예약을 취소하시겠습니까? (Y/N)		   ");
		System.out.println();
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out.print("입력(Y/N): ");
	}

	/**
     * 사용자의 입력을 받아 반환하는 메서드입니다.
     * @return 사용자가 입력한 문자열
     */
	public static String get() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	/**
     * 예약 취소할 예약번호를 입력받는 메서드입니다.
     * @return 사용자가 입력한 정수값
     */
	public static int getStoreName() {
		Scanner scan = new Scanner(System.in);
		System.out.print("예약 취소할 예약번호 입력: ");
		return View.getSelectType();
	}

	/**
     * 예약 내역이 없을 경우 메시지를 표시하는 메서드입니다.
     */
	public static void showNoReservationHistoryMessage() {
		System.out.println();
		System.out.println("예약 내역이 존재하지 않습니다.");
		System.out.println();
		View.pause();
	}

	/**
     * 예약을 취소할지 묻는 메시지를 표시하는 메서드입니다.
     */
	public static void showAskCancelMessage() {
		System.out.println();
		System.out.println("예약을 취소하시겠습니까?");
		System.out.println();
		View.pause();		
	}

	/**
     * 예약이 취소되었다는 메시지를 표시하는 메서드입니다.
     */
	public static void showCancelMessage() {
		System.out.println();
		System.out.println("예약이 취소되었습니다.");
		System.out.println();
		View.pause();
	}

	 /**
     * 예약 취소 과정이 중지되었다는 메시지를 표시하는 메서드입니다.
     */
	public static void showStopCancelMessage() {
		System.out.println();
		System.out.println("예약 취소 과정을 중지합니다.");
		System.out.println();
		View.pause();
		
	}

	/**
     * 유효하지 않은 예약 번호를 입력했을 때의 메시지를 표시하는 메서드입니다.
     */
	public static void incorrectReservationNumber() {
		System.out.println();
		System.out.println("유효한 예약 번호가 아닙니다.");
		System.out.println("리스트에 보여진 예약 번호를 입력해주세요.");
		System.out.println();
		View.pause();
	}


}
