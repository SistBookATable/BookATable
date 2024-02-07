package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Reservation;
import com.test.java.repository.Data;

public class PointRefundHistoryView {
	
	
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
	
	public String get() {
		
		Scanner scan = new Scanner(System.in);
	
		String temp = scan.nextLine();
		return temp;
	}

	public void noHistoryMessage() {

		System.out.println();
		System.out.println("■           포인트 환불내역이 없습니다.		   ■");
		System.out.println();
		View.pause();
		
	}

	public void successMessage() {

		System.out.println();
		System.out.println("■           환불 신청이 취소되었습니다.		   ■");
		System.out.println();
		View.pause();
	}

	public void cancelMessage() {

		System.out.println();
		System.out.println("■           환불 취소 과정을 중지합니다.		   ■");
		System.out.println();
		View.pause();
	}

	public void incorrectInputMessage() {
		System.out.println();
		System.out.println("■              잘못된 입력입니다.      		   ■");
		System.out.println();
		View.pause();
	}

	public void cannotCancelMessage() {
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■        계좌로 지급이 완료되어 환불 취소가 불가능합니다.	   ■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		View.pause();
		
	}

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
