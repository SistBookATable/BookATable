package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.repository.ReservationRepository;
import com.test.java.view.ReservationCancelView;
import com.test.java.view.View;

public class ReservationCancelController {
	public void reservationCancel() {
		ReservationCancelView.showReservationCancel();
		String input = ReservationCancelView.get();
		if (input.equalsIgnoreCase("Y")) {
			
			int reservationNumber = ReservationCancelView.getStoreName();
			
			Reservation selected = ReservationRepository.findOneByReservationNumber(reservationNumber, Member.id);
			
			if(selected == null) {
				ReservationCancelView.incorrectReservationNumber();
				return;
			}
			
			//예약 상태 "취소"로 변경
			selected.setState("취소");
			ReservationCancelView.showCancelMessage();

		} else if (input.equalsIgnoreCase("N")) {
			ReservationCancelView.showStopCancelMessage();
		}

	}

}
