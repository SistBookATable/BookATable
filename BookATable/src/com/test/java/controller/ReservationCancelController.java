package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.view.ReservationCancelView;
import com.test.java.view.View;

public class ReservationCancelController {
	public void reservationCancel() {
		ReservationCancelView reservationCancelView
			= new ReservationCancelView();
		reservationCancelView.showReservationCancel();
		
		boolean loop = true;
		while(loop) {
			if (reservationCancelView.get().equalsIgnoreCase("Y")) {
				System.out.println("예약을 취소하시겠습니까?");
				reservationCancelView.isCanCel();
				System.out.println("예약이 취소되었습니다.");
				View.pause();
				loop = false;
			} else {
				System.out.println("예약 취소 과정을 중지합니다.");
				View.pause();
				loop = false;
			}
			
		}
	}
}
