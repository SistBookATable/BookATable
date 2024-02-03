package com.test.java.view;

import java.util.Scanner;

public class ReservationCancelView {
public void showReservationCancel() {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("           예약을 취소하시겠습니까? (Y/N)		   ");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.print("입력(Y/N): ");
	}

	public String get() {
		Scanner scan = new Scanner(System.in);
		String answer = scan.nextLine();
		
		return answer;
	}

	public void isCanCel() {
		//TODO 예약취소가 어떻게 되는건지,,? 예약 내역 중에 취소할 예약의 상호명을 적으면 해당 예약을 취소,,??
	}

}
