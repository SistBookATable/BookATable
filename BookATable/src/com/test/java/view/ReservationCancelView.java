package com.test.java.view;

import java.util.Scanner;

public class ReservationCancelView {
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

	public static String get() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public static int getStoreName() {
		Scanner scan = new Scanner(System.in);
		System.out.print("예약 취소할 예약번호 입력: ");
		return View.getSelectType();
	}

	public static void showNoReservationHistoryMessage() {
		System.out.println();
		System.out.println("예약 내역이 존재하지 않습니다.");
		System.out.println();
		View.pause();
	}

	public static void showAskCancelMessage() {
		System.out.println();
		System.out.println("예약을 취소하시겠습니까?");
		System.out.println();
		View.pause();		
	}

	public static void showCancelMessage() {
		System.out.println();
		System.out.println("예약이 취소되었습니다.");
		System.out.println();
		View.pause();
	}

	public static void showStopCancelMessage() {
		System.out.println();
		System.out.println("예약 취소 과정을 중지합니다.");
		System.out.println();
		View.pause();
		
	}

	public static void incorrectReservationNumber() {
		

		System.out.println();
		System.out.println("유효한 예약 번호가 아닙니다.");
		System.out.println("리스트에 보여진 예약 번호를 입력해주세요.");
		System.out.println();
		View.pause();
	}


}
