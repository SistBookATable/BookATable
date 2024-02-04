package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Reservation;
import com.test.java.repository.Data;

public class PointRefundHistoryView {
	
	public static void showPointRefundHistory(String userName, int balance) {
		
		// 환불 신청 내역
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 환불 신청 내역		   ■", userName);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");

		
		// 보유포인트금액 == 환불금액? 
		System.out.println();
		System.out.println("[환불신청일]\t[포인트금액]");
		System.out.printf("			%d", balance);
		


		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■           환불 취소하시겠습니까? (Y/N)		   ■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.print("입력(Y/N) : ");
		System.out.println();
		
		
	}
	
	public static String get() {
		
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		scan.close();
		
		return temp;
	}


}
