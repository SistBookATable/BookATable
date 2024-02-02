package com.test.java.view;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.repository.Data;

public class InquiryCompletedReservationsView {

	public void showInquiryCompletedReservation(String userName, String reserveDate, String storeName, int numOfPeple
												, String canceledReservationState, String noShowState, String reviewState) {
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 현재 예약 현황		   ■", userName);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");

		System.out.println();
		System.out.printf("[예약일]\t|\t[상호명]\t|\t[인원수]\t|\t[예약 취소]\t|\t[노쇼]\t|\t[리뷰 작성]\t\n");
		System.out.printf("%s \t|\t %s \t|\t %d \t|\t %s \t|\t %s \t|\t %s \t|\t\n"
						, reserveDate, storeName, numOfPeple, canceledReservationState, noShowState, reviewState);
		
		

		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■           1. 리뷰 작성하기	   ■");
		System.out.println("■           0. 이전 화면		   ■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.print("선택(번호) : ");
		System.out.println();
	}

	

	

}
