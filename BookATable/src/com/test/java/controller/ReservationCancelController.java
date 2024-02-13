package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.repository.ReservationRepository;
import com.test.java.view.ReservationCancelView;

/**
 * 예약 취소를 처리하는 컨트롤러 클래스입니다.
 */
public class ReservationCancelController {
	
	public void reservationCancel() {
		ReservationCancelView.showReservationCancel();
		String input = ReservationCancelView.get();
		if (input.equalsIgnoreCase("Y")) {
			
			int reservationNumber = ReservationCancelView.getStoreName();
			
			 // 사용자의 아이디로 예약번호와 일치하는 예약 정보를 찾음
			Reservation selected = ReservationRepository.findOneByReservationNumber(reservationNumber, Member.id);
			
			if(selected == null) {
				// 일치하는 예약 정보가 없을 경우 메시지 출력 후 종료
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
