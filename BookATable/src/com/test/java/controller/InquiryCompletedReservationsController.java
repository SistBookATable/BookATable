package com.test.java.controller;

import java.util.Iterator;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.InquiryCompletedReservationsView;

public class InquiryCompletedReservationsController {

	public void inquiryCompletedReservations() {
		InquiryCompletedReservationsView inquiryCompletedReservationsView = new InquiryCompletedReservationsView();

		inquiryCompletedReservationsView.showInquiryCompletedReservation(findNameById(Member.id)
																		,findReserveDateById(Member.id)
																		, findStoreName(Member.id)
																		, findNumOfPeple(Member.id)
																		, findCanceledReservationState(Member.id)
																		, findNoShowState(Member.id)
																		, findReviewState(Member.id));
	}

	private String findReviewState(String id) {
		
		
		return null;
	}

	private String findNoShowState(String id) {
		String noShowState = "";
		
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				noShowState = (r.getState().equals("노쇼")) ? "O" : "X";
			}
		}
		
		return noShowState;
	}

	private String findCanceledReservationState(String id) {
		String canceledReservationState = "";
		
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				canceledReservationState =  (r.getState().equals("취소")) ? "O" : "X";
			}
		}
		return canceledReservationState;
	}

	private int findNumOfPeple(String id) {
		int numOfPeple = 0;

		for (Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				numOfPeple = r.getNumOfPeople();
			}
		}

		return numOfPeple;
	}

	private String findStoreName(String id) {
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

	private String findReserveDateById(String id) {
		String reserveDate = "";

		for (Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				reserveDate = r.getReservationDate();
			}
		}
		return reserveDate;
	}

	private String findNameById(String id) {
		String name = "";

		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				name = u.getName();
				break;
			}
		}
		return name;

	}

}
