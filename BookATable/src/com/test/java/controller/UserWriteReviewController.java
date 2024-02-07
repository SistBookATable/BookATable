package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.InquiryCompletedReservationView;
import com.test.java.view.UserWriteReviewView;

public class UserWriteReviewController {

	public void userWriteReview() {
		boolean loop = true;
		while(loop) {
			ArrayList<Reservation> noReviewReservation = findAllNoReviewReservation(Member.id);
			
			if (noReviewReservation.isEmpty()) {
				UserWriteReviewView.showNoReviewMessage();
				break;
			}
			
			String userName = findNameById(Member.id);
			UserWriteReviewView.showNoReviewReservation(userName);
			
			String storeName = findStoreName(Member.id);
			String cancelState = findCancelState(Member.id);
			String noShowState = findNoShowState(Member.id);
			String reviewState = findReviewState(Member.id);

			for(Reservation r : noReviewReservation) {
				InquiryCompletedReservationView.showOneReservation(r, storeName, cancelState, noShowState, reviewState);
			}
			
			String intputStoreName = UserWriteReviewView.getStoreName();
			if (storeName.equals(intputStoreName)) {
				String reviewContent = UserWriteReviewView.getReviewContent();
				addReview(reviewContent);
			}
			
			
		}
	}


	private void addReview(String reviewContent) {
		for(Reservation r : Data.reservationList) {
			if (r.getState().equals("취소")) {
//				TODO 일반회원의 리뷰리스트 중 리뷰 내용을 reviewContent로 바꿈
			}
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

	private String findNameById(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getName();
			}
		}
		return null;
	}

	private ArrayList<Reservation> findAllNoReviewReservation(String id) {
		ArrayList<Reservation> tmp = new ArrayList<Reservation>();
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id) && r.getState().equals("취소")) {
				tmp.add(r);
			}
		}
		return tmp;
	}

}
