package com.test.java.controller;

import java.util.ArrayList;
import java.util.Iterator;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.InquiryCompletedReservationView;
import com.test.java.view.View;

public class InquiryCompletedReservationController {

	public void inquiryCompletedReservation() {
		
		boolean loop = true;
		while (loop) {
			
			ArrayList<Reservation> visitedList = findAllRerservation(Member.id);
			
			if (visitedList.isEmpty()) {
				InquiryCompletedReservationView.showNoVisitationMessage();
				break;
			}
			
			String userName = findNameById(Member.id);
			InquiryCompletedReservationView.showTitle(userName);
			
			for(Reservation r : visitedList) {
				String storeName = findStoreName(Member.id);
				String cancelState = findCancelState(Member.id);
				String noShowState = findNoShowState(Member.id);
				String reviewState = findReviewState(Member.id);
				InquiryCompletedReservationView.showOneReservation(r, storeName, cancelState, noShowState, reviewState);
			}
			
			InquiryCompletedReservationView.showSelecBox();
			int choice = InquiryCompletedReservationView.get();
			
			switch (choice) {
			case 1:
				UserWriteReviewController userWriteReviewController = new UserWriteReviewController();
				userWriteReviewController.userWriteReview();
				break;
			case 0 :
				loop = false;
				break;
			}
			View.pause();
		}
	}

	private String findReviewState(String id) {
		for(Review review : Data.reviewList) {
			if (review.getUserId().equals(id)) {
				for(Reservation reservation : Data.reservationList) {
					if (reservation.getUserId().equals(id)) {
						return reservation.getState();
					}
				}
			}
		}
		return null;
	}

	private String findNoShowState(String id) {
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				String noShowState = (r.getState().equals("노쇼")) ? "O" : "X";
				return noShowState;
			}
		}
		return null;
	}


	private String findCancelState(String id) {
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				String cancelState = (r.getState().equals("취소")) ? "O" : "X" ;
				return cancelState;
			}
		}
		return null;
	}


	private String findStoreName(String id) {
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				for(Store s : Data.storeList) {
					if (s.getLicenseNumber().equals(r.getLicenseNumber())) {
						return s.getStoreName();
					}
				}
			}
		}
		
		return null;
	}

	private ArrayList<Reservation> findAllRerservation(String id) {
		ArrayList<Reservation> tmp = new ArrayList<Reservation>();
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				tmp.add(r);
			}
		}
		return tmp;
	}

	private String findNameById(String id) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getName();
			}
		}
		return null;
	}
}
