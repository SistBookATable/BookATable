package com.test.java.view;

import java.util.Iterator;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.repository.Data;

public class InquiryReservationStatusView {
	
	public static void showUserReservationHeader(String userName) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("|                 %s님 현재 예약 현황              	  <\n", userName);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%-10s%-20s%-25s%-25s", "[예약 번호]", "[예약 상호명]","[예약 인원 수]","[예약 시간]");
		System.out.println(header);
		
	}
	
	public static void showOneReservation(Reservation r, String storeName) {
		String tmp = "";
		tmp = String.format("%-10s%-20s%-25s%-25s"
				,r.getReservationNumber()
				, storeName
				,r.getNumOfPeople() + "명"
				, r.getReservationTime().substring(0, 2) + ":" + r.getReservationTime().substring(2));
		System.out.println(tmp);
	}
	
	public static void showSelectBox() {
			
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
		return View.getSelectType();
	}

	public static void showNoReservationMessage() {
		System.out.println();
		System.out.println("현재 예약이 없습니다.");
		System.out.println();
		View.pause();
	}




	
}
