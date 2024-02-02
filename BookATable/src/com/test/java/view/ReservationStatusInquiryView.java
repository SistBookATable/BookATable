package com.test.java.view;

import java.util.Iterator;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.repository.Data;

public class ReservationStatusInquiryView {
	
	
	public void showReservationStatusInquiry() {

		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 현재 예약 현황		   ■", findNameById(Member.id));
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");

		System.out.println();
		System.out.printf("[상호명]\t[인원수]\t[예약 시간]");
		
		while(true) {
			for(Reservation r : Data.reservationList) {
				if (r.getState().equals("예약")) {
					System.out.printf("%s\t%d명\t%s\t\n",findStoreNameById(Member.id), findNumOfPepleById(Member.id), findreservationTimeById(Member.id));
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

	private String findreservationTimeById(String id) {
		String reservationTime = "";
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				reservationTime = r.getReservationTime();
			}
		}
		
		return reservationTime;
	}

	private int findNumOfPepleById(String id) {
		int numOfPeple = 0;
		
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				numOfPeple = r.getNumOfPeople();
			}
		}
		
		return numOfPeple;
	}

	private String findStoreNameById(String id) {
		String storeName = "";
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				for(Store s : Data.storeList) {
					if (r.getLicenseNumber().equals(s.getStoreName())) {
						storeName = s.getStoreName();
					}
				}
				
			}
		
		}
		
		return storeName;
	}

	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		
		return temp;
	}

	private String findNameById(String id) {
		String name = "";

		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				name = u.getName();
				break;
			}
		}
		return name;
		
	}
	
	


}
