package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.InquiryReservationStatusView;
import com.test.java.view.View;

public class InquiryReservationStatusController {

	public void inquiryReservationStatus() {

		boolean loop = true;
		while (loop) {
			
			ArrayList<Reservation> userReservationList = findAllReservation(Member.id);

			String userName = findNameById(Member.id);
			InquiryReservationStatusView.showUserReservationHeader(userName);
			
			if (userReservationList.isEmpty()) {
				InquiryReservationStatusView.showNoReservationMessage();
				break;
			}
			
			
			for(Reservation r : userReservationList) {
					String storeName = findStoreNameByLisenceNumber(r.getLicenseNumber());
					InquiryReservationStatusView.showOneReservation(r, storeName);
			}
			
			InquiryReservationStatusView.showSelectBox();
			int choice = InquiryReservationStatusView.get();

			switch (choice) {
			case 1:
				ReservationCancelController reservationCancelController = new ReservationCancelController();
				reservationCancelController.reservationCancel();
				break;
			case 0:
				loop = false;
				break;
			default:
				break;
			}
		}
	}

	private String findStoreNameByLisenceNumber(String licenseNumber) {
		for(Store s : Data.storeList) {
			if (s.getLicenseNumber().equals(licenseNumber)) {
				return s.getStoreName();
			}
		}
		return null;
	}


	private ArrayList<Reservation> findAllReservation(String id) {
		ArrayList<Reservation> tmp = new ArrayList<>();
		for (Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id) && r.getState().equals("예약")) {
				tmp.add(r);
			}
		}

		return tmp;
	}

	private String findNameById(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getName();
			}
		}
		return null;

	}

}