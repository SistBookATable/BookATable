package com.test.java.controller;

import java.util.Calendar;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.InquiryCompletedReservationView;

public class InquiryCompletedReservationController {

	public void inquiryCompletedReservation() {
		InquiryCompletedReservationView.showInquiryCompletedReservation(findNameById(Member.id)
																		, findReserveDateById(Member.id)
																		, findstoreNameById(Member.id)
																		, findNumOfPepleById(Member.id)
																		, findCancelStateById(Member.id)
																		, findNoshowStateById(Member.id)
																		, findReviewStateById(Member.id));
		
		while(true) {
			int choice = InquiryCompletedReservationView.get();
			switch(choice) {
				case 1:
					InquiryCompletedReservationView.inputStoreName();
					String review = InquiryCompletedReservationView.writeReview();
					addReview(review, Member.id);
			 
			}
		}
	}



	private void addReview(String review, String id) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				for(Review r : Data.reviewList) {
					if (r.getUserId().equals(id)) {
						Data.reviewList.add(review);
					}
				}
			}
		}
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

	private String findReserveDateById(String id) {
		String reserveDate = "";

		for (Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				reserveDate = r.getReservationDate();
			}
		}
		return reserveDate;
	}

	private String findstoreNameById(String id) {
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

	private String findCancelStateById(String id) {
		String canceledReservationState = "";

		for (Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				canceledReservationState = (r.getState().equals("취소")) ? "O" : "X";
			}
		}
		return canceledReservationState;
	}

	private String findNoshowStateById(String id) {
		String noShowState = "";

		for (Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				noShowState = (r.getState().equals("노쇼")) ? "O" : "X";
			}
		}

		return noShowState;
	}

	private String findReviewStateById(String id) {
		String reviewState = "";
		for(Review r : Data.reviewList) {
			reviewState = (r.getUserId().equals(id)) ? "O" : "X";
		}
		return reviewState;
	}

}
