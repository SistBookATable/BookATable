package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.ReservationRepository;
import com.test.java.repository.ReviewRepository;
import com.test.java.repository.StoreRepository;
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
			
			
			String lisenceNumber = ReservationRepository.findOneById(Member.id).getLicenseNumber();
			String storeName = StoreRepository.findNameOneByLicenseNumber(lisenceNumber);
			
			for(Reservation r : noReviewReservation) {
				String reservationDate = findReservationDate(Member.id);
				String numOfPeple = findNumOfPeple(Member.id);
				String cancelState = findCancelState(Member.id);
				String noShowState = findNoShowState(Member.id);
				String reviewState = findReviewState(Member.id);
				
				UserWriteReviewView.showOneReserVation(reservationDate, storeName, numOfPeple, cancelState, noShowState, reviewState);
			}
			
			String intputStoreName = UserWriteReviewView.getStoreName();
			
			if (storeName.equals(intputStoreName)) {
				String reviewContent = UserWriteReviewView.getReviewContent();
				addReview(reviewContent);
				System.out.println("리뷰 작성이 완료되었습니다.");
				loop = false;
			}
			break;
		}
	}

	private String findNumOfPeple(String id) {
		for(Member m : Data.memberList) {
			if (m.getId().equals(id)) {
				for(Reservation r : Data.reservationList) {
					if (r.getUserId().equals(id)) {
						return String.valueOf(r.getNumOfPeople());
					}
				}
			}
		}
		return null;
	}

	private String findReservationDate(String id) {
		for(Member m : Data.memberList) {
			if (m.getId().equals(id)) {
				for(Reservation r : Data.reservationList) {
					if (r.getUserId().equals(id)) {
						return r.getReservationDate();
					}
				}
			}
		}
		return null;
	}

	private void addReview(String reviewContent) {
		for (Review review : Data.reviewList) {
			if (review.getContent().equals("null")) {
				review.setContent(reviewContent);
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
		for(Reservation reservation : Data.reservationList) {
			if (reservation.equals(id)) {
				for(Review review : Data.reviewList) {
					if (review.getUserId().equals(reservation.getUserId())) {
						tmp.add(reservation);
					}
				}
			}
		}
		return tmp;
	}

}
