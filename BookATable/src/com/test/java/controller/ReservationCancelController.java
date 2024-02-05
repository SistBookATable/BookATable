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

		boolean loop = true;
		while (loop) {
			if (ReservationCancelView.get().equalsIgnoreCase("Y")) {
				System.out.println("예약을 취소하시겠습니까?");
				String inputStoreName = ReservationCancelView.getStoreName();
				// 현재 유저의 예약 리스트 중 상호명이 storeName과 같은 예약을 삭제한다.
				
				// 1. 예약리스트 중, 현재 유저의 id와 같은 예약을 찾아서 해당 예약의 번호를 반환한다.
				String reservationNumber = findReservationNumberById(Member.id);
				
				// 2. 예약 리스트 중, 예약 번호와 같은 예약을 찾아서 해당 예약의 상호명을 반환한다.
				findStoreNameByReservation(reservationNumber);
				
				// 3. 반환된 상호명과 입력받은 상호명이 같은지 확인한다.
				boolean checkStoreName = checkStoreName(inputStoreName, findStoreNameByReservation(reservationNumber));
				
				// 4. 일치할 때예약 상태 "취소"로 변경
				if (checkStoreName) {
					modifyReservationState(inputStoreName, Member.id);
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

	private void modifyReservationState(String inputStoreName, String id) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				for(Reservation r : Data.reservationList) {
					r.setState("취소");
				}
			}
		}
		
	}

	private boolean checkStoreName(String inputStoreName, String storeNameByReservation) {
		if (inputStoreName.equals(storeNameByReservation)) {
			return true;
		}

		return false;
	}

	private String findStoreNameByReservation(String reservationNumber) {
		for (Reservation r : Data.reservationList) {
			if (r.getLicenseNumber().equals(reservationNumber)) {
				for (Store s : Data.storeList) {
					if (s.getLicenseNumber() == r.getLicenseNumber()) {
						return s.getStoreName();
					}
				}
			}
		}
		return null;
	}

	private String findReservationNumberById(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				for (Reservation r : Data.reservationList) {
					if (r.getUserId().equals(id)) {
						return r.getLicenseNumber();
					}
				}
			}
		}

		return null;
	}

}
