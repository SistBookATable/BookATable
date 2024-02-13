package com.test.java.view;

import java.util.Iterator;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.repository.Data;

/**
 * InquiryReservationStatusView 클래스는 실시간 예약 현황을 출력하는 클래스입니다.
 * 또한, 회원의 선택을 입력받아 예약취소 하는 화면으로 이동할 수 있습니다.
 */
public class InquiryReservationStatusView {
	
	/**
	 * 사용자의 예약 현황을 헤더 형식으로 출력합니다.
	 * @param userName 사용자 이름
	 */
	public static void showUserReservationHeader(String userName) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("|                 %s님 현재 예약 현황              	  	|\n", userName);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%-10s%-20s%-25s%-25s", "[예약 번호]", "[예약 상호명]","[예약 인원 수]","[예약 시간]");
		System.out.println(header);
		
	}
	
	/**
	 * 하나의 예약 정보를 출력합니다.
	 * @param r 예약 정보 객체
	 * @param storeName 상호명
	 */
	public static void showOneReservation(Reservation r, String storeName) {
		String tmp = "";
		tmp = String.format("%-10s%-20s%-25s%-25s"
				,r.getReservationNumber()
				,storeName
				,r.getNumOfPeople() + "명"
				,r.getReservationTime().substring(0, 2) + ":" + r.getReservationTime().substring(2));
		System.out.println(tmp);
	}
	
	/**
     * 선택 옵션을 출력하는 메서드입니다.
     */
	public static void showSelectBox() {
			
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■           1. 예약 취소	\t■");
		System.out.println("■           0. 이전 화면	\t■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.print("선택(번호) : ");
		System.out.println();
	}
	
	/**
     * 사용자가 선택한 번호를 반환하는 메서드입니다.
     * @return 선택 번호
     */
	public static int get() {
		return View.getSelectType();
	}

	/**
     * 예약 내역이 없는 경우에 메시지를 출력하는 메서드입니다.
     */
	public static void showNoReservationMessage() {
		System.out.println();
		System.out.println("현재 예약이 없습니다.");
		System.out.println();
		View.pause();
	}

	
}
