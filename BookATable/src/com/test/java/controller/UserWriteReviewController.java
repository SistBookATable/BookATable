package com.test.java.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Review;
import com.test.java.repository.Data;
import com.test.java.repository.ReviewRepository;
import com.test.java.repository.StoreRepository;
import com.test.java.view.InquiryCompletedReservationView;
import com.test.java.view.UserWriteReviewView;

public class UserWriteReviewController {

	public void userWriteReview(ArrayList<Reservation> reservations) {
		ArrayList<Reservation> noReviewReservation = findAllNoReviewReservation(reservations,Member.id);
		
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
			UserWriteReviewView.showOneReserVation(r, StoreRepository.findOneByLicenseNumber(r.getLicenseNumber()).getStoreName());
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
			
			String userName = findNameById(Member.id);
			UserWriteReviewView.showNoReviewReservation(userName);
			
			ArrayList<Integer> stringArr = new ArrayList<>();
			for(Reservation r : noReviewReservation) {
				String storeName = StoreRepository.findNameOneByLicenseNumber(r.getLicenseNumber());
				stringArr.add(r.getReservationNumber());
				String cancelState = r.getState().equals("취소")== true? "O" : "X";
				String noShowState = r.getState().equals("노쇼")== true? "O" : "X";
				String reviewState = ReviewRepository.findOneById(Member.id, r.getLicenseNumber()) == true ? "O" : "X";
				UserWriteReviewView.showOneReserVation(r, storeName, cancelState, noShowState, reviewState);
			}
			
			int inputReservationNumber = UserWriteReviewView.getReservationNumber();
			if (stringArr.contains(inputReservationNumber)) {
				String reviewContent = UserWriteReviewView.getReviewContent();
				double score = UserWriteReviewView.getReviewScore();
				addReview(reviewContent, inputReservationNumber, score);
				System.out.println("리뷰 작성이 완료되었습니다.");
				View.pause();
				loop = false;
			}
		}
		return null;
	}

	private void addReview(String reviewContent, int reservationNumber, double score) {		
		int reviewNumber = Data.reviewList.size()+1;
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		String dateWritten = dateformat.format(c.getTime());
		String userId = "";
		String licenseNumber = "";
		for(Reservation r : Data.reservationList) {
			if (r.getReservationNumber() ==  reservationNumber){
				userId = r.getUserId();
				licenseNumber = r.getLicenseNumber();
			}
		}
        
		Review newReview = new Review(reviewNumber, userId, licenseNumber, dateWritten, reviewContent, score, reservationNumber);
		Data.reviewList.add(newReview);
	}

	private String findNameById(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getName();
			}
		}
		return null;
	}

	private ArrayList<Reservation> findAllNoReviewReservation(ArrayList<Reservation> reservations, String id) {
		ArrayList<Reservation> tmp = new ArrayList<Reservation>();
		
		for(Reservation r : reservations) {
			if (r.getUserId().equals(id) && r.getState().equals("방문")) {
				if(!ReviewRepository.findOneById(Member.id, r.getLicenseNumber())) {
					tmp.add(r);	
				}
			}
		}
		return tmp;
	}

}
