package com.test.java.controller;

import java.util.Scanner;

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
			InquiryReservationStatusView.showInquiryReservationStatus(findNameById(Member.id), findStoreNameById(Member.id),
					findNumOfPepleById(Member.id), findReservationTimeById(Member.id));
			int choice = InquiryReservationStatusView.get();
			
			switch (choice) {
			case 1:
				ReservationCancelController reservationCancelController = new ReservationCancelController();
				reservationCancelController.reservationCancel();
				break;
			case 0:
				break;
			}
		}

	}

	private String findNameById(String id) {
		String userName = "";
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				userName = u.getName();
				break;
			}
		}
		return userName;

	}

	private String findStoreNameById(String id) {
		String storeName = "";
		for (Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				for (Store s : Data.storeList) {
					if (r.getLicenseNumber().equals(s.getStoreName())) {
						storeName = s.getStoreName();
					}
				}

			}
		}
		return storeName;
	}

	private int findNumOfPepleById(String id) {
		int numOfPeple = 0;
		for (Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				numOfPeple = r.getNumOfPeople();
			}
		}
		return numOfPeple;
	}

	private String findReservationTimeById(String id) {
		String reservationTime = "";
		for (Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				reservationTime = r.getReservationTime();
			}
		}
		return reservationTime;
	}

}