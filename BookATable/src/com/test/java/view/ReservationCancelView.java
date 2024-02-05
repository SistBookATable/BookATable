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

}
