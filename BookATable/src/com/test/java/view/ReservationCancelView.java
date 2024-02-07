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

	public static String getStoreName() {
		Scanner scan = new Scanner(System.in);
		System.out.print("예약 취소 상호명 입력: ");
		return scan.nextLine();
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


}
