package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.view.ReservationCancelView;
import com.test.java.view.ReservationStatusInquiryView;

public class ReservationCancelController {
	public void reservationCancel() {
		ReservationCancelView reservationCancelView
			= new ReservationCancelView();
		reservationCancelView.showReservationCancel();
		
		boolean loop = true;
		while(loop) {
			if (reservationCancelView.get().equalsIgnoreCase("Y")) {
				System.out.println("입력을 취소하시겠습니까?");
				reservationCancelView.isCanCel();
			} else {
				System.out.println("예약 취소 과정을 중지합니다.");
				loop = false;
			}
			
		}
	}
}
