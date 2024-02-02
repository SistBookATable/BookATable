package com.test.java.view;

import java.util.Scanner;

public class ReservationCancelView {
public void showReservationCancel() {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("           예약을 취소하시겠습니까? (Y/N)		   ");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.print("입력(Y/N)");
	}

	public String get() {
		Scanner scan = new Scanner(System.in);
		String answer = scan.nextLine();
		
		return answer;
	}

	public void isCanCel() {
		
	}

}
