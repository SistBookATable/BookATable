package com.test.java.controller;

import java.util.ArrayList;

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
				ReservationCancelView.showAskCancelMessage();
				
				String inputStoreName = ReservationCancelView.getStoreName();
				
				String lisenceNumber = findLicenseNumber(inputStoreName, Member.id);
				
				ArrayList<Reservation> userReservationList = findAllReservation(lisenceNumber);
				
				boolean isValidLisenceNumber = checkLisenceNumber(lisenceNumber, Member.id);
				
				if (userReservationList.isEmpty()) {
					ReservationCancelView.showNoReservationHistoryMessage();
					loop = false;
				}
				
				//일치할 때, 예약 상태 "취소"로 변경
				if (isValidLisenceNumber) {
					modifyReservationState(lisenceNumber, Member.id);
					ReservationCancelView.showCancelMessage();
					loop = false;
				}

				break;
			} else if (ReservationCancelView.get().equalsIgnoreCase("N")) {
				ReservationCancelView.showStopCancelMessage();
				View.pause();
				break;
			}
			loop = false;

		}
	}

	private ArrayList<Reservation> findAllReservation(String lisenceNumber) {
		ArrayList<Reservation> tmp = new ArrayList<Reservation>();
		for(Reservation r : Data.reservationList) {
			if (r.getLicenseNumber().equals(lisenceNumber)) {
				tmp.add(r);
			}
		}
		
		return tmp;
	}

	private void modifyReservationState(String lisenceNumber, String id) {
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				r.setState("취소");
			}
		}
		
	}

	private boolean checkLisenceNumber(String lisenceNumber, String id) {
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				if (r.getLicenseNumber().equals(lisenceNumber)) {
					return true;
				}
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
