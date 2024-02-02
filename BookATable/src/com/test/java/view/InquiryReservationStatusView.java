package com.test.java.view;

import java.util.Iterator;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.repository.Data;

public class InquiryReservationStatusView {
	
	
	public static void showInquiryReservationStatus(String userName, String storeName , int numOfPeple, String reservationTime) {

		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 현재 예약 현황		   ■", userName);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");

		System.out.println();
		System.out.printf("[상호명]\t[인원수]\t[예약 시간]");
		
		while(true) {
			for(Reservation r : Data.reservationList) {
				if (r.getState().equals("예약")) {
					System.out.printf("%s\t%d명\t%s\t\n", storeName, numOfPeple, reservationTime);
				}
			}
			break;
		}

		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■           1. 예약 취소		   ■");
		System.out.println("■           0. 이전 화면		   ■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.print("선택(번호) : ");
		System.out.println();
	}
	
	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		
		return temp;
	}

	
}
