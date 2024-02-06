package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.ReservationCancelView;
import com.test.java.view.View;

public class ReservationCancelController {
	public void reservationCancel() {
		ReservationCancelView.showReservationCancel();
//		oknexuf
//		hsbmt@

		boolean loop = true;
		while (loop) {
			if (ReservationCancelView.get().equalsIgnoreCase("Y")) {
				System.out.println("예약을 취소하시겠습니까?");
				
				//예약 취소할 상호명 입력받기
				String inputStoreName = ReservationCancelView.getStoreName();
				
				//입력받은 상호명으로 해당 음식점의 라이센스넘버 찾기
				String lisenceNumber = findLicenseNumber(inputStoreName, Member.id);
				
				//입력받은 상호명의 라이센스 넘버와 일반회원의 예약의 라이센스 넘버가 같은지 확인 
				boolean checkStoreName = checkStoreName(lisenceNumber, Member.id);
				
				//일치할 때예약 상태 "취소"로 변경
				if (checkStoreName) {
					modifyReservationState(lisenceNumber, Member.id);
					System.out.println("예약이 취소되었습니다.");
					View.pause();
					loop = false;
				}

				break;
			} else if (ReservationCancelView.get().equalsIgnoreCase("N")) {
				System.out.println("예약 취소 과정을 중지합니다.");
				View.pause();
				break;
			}
			loop = false;

		}
		View.pause();
	}

	private void modifyReservationState(String lisenceNumber, String id) {
		
		
	}

	private boolean checkStoreName(String lisenceNumber, String id) {
		for(Reservation r : Data.reservationList) {
			if (r.getLicenseNumber().equals(lisenceNumber) && r.getUserId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	private String findLicenseNumber(String inputStoreName, String id) {
		for(Store s : Data.storeList) {
			if (s.getStoreName().equals(inputStoreName)) {
				return s.getLicenseNumber();
			}
		}
		return null;
	}

}
