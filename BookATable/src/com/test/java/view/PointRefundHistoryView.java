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
		
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■           환불 취소하시겠습니까? (Y/N)		   ■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.print("입력(Y/N) : ");
		
	}
	
	public static String get() {
		
		Scanner scan = new Scanner(System.in);
	
		String temp = scan.nextLine();
		return temp;
	}


}
