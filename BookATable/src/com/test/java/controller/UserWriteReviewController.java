package com.test.java.controller;

import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.repository.ReviewRepository;
import com.test.java.view.InquiryCompletedReservationView;
import com.test.java.view.UserWriteReviewView;

public class UserWriteReviewController {

	public void userWriteReview(ArrayList<Reservation> reservations) {
		ArrayList<Reservation> noReviewReservation = findAllNoReviewReservation(Member.id);
		
		if (noReviewReservation.isEmpty()) {
			UserWriteReviewView.showNoReviewMessage();
			return;
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
		
		int reservationNumber = UserWriteReviewView.getStoreName();
		
		Reservation selected = isValid(reservationNumber,reservations);
		
		if(selected == null) {
			UserWriteReviewView.incorrectReservationNumber();
			return;
		}
		
		if(ReviewRepository.findOne(reservationNumber)!=null) {
			UserWriteReviewView.alreadyHasReview();
			return;
		}
		
		String lisenceNumber = selected.getLicenseNumber();
		double score = UserWriteReviewView.getScore();
		String reviewContent = UserWriteReviewView.getReviewContent();
		
		Calendar cur = Calendar.getInstance();
		String today = String.format("%tF", cur);
		
		
		ReviewRepository.add(0, Member.id, lisenceNumber, today, reviewContent, score, reservationNumber);

		System.out.println("리뷰 작성이 완료되었습니다.");
		
	}

	private Reservation isValid(int reservationNumber, ArrayList<Reservation> reservations) {
		
		for(Reservation r : reservations) {
			if(r.getReservationNumber() == reservationNumber) {
				return r;
			}
		}
		return null;
	}

	private void addReview(String reviewContent) {
		for (Reservation reservation : Data.reservationList) {
			if (reservation.getState().equals("취소")) {
				for (Review review : Data.reviewList) {
					if (review.getContent().equals(null)) {
						review.setContent(reviewContent);
					}
				}
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
			if (r.getUserId().equals(id) && !r.getState().equals("취소") && !r.getState().equals("노쇼")) {
				tmp.add(r);
			}
		}
		return tmp;
	}

}
