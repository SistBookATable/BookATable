package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.ReviewRepository;
import com.test.java.repository.StoreRepository;
import com.test.java.view.InquiryCompletedReservationView;

public class InquiryCompletedReservationController {

	public void inquiryCompletedReservation() {
		boolean loop = true;
		while (loop) {
			
			ArrayList<Reservation> visitedList = findAllRerservation(Member.id);
			
			if (visitedList.isEmpty()) {
				InquiryCompletedReservationView.showNoVisitationMessage();
				break;
			}
			
			String userName = MemberRepository.findOneById(Member.id).getName();
			InquiryCompletedReservationView.showTitle(userName);
			
			for(Reservation r : visitedList) {
				String lisenceNumber = r.getLicenseNumber();
				String storeName = StoreRepository.findNameOneByLicenseNumber(lisenceNumber);
				String state = r.getState();
				String cancelState = state.equals("취소")?"O":"X";
				String noShowState = state.equals("노쇼")?"O":"X";
				String reviewState = ReviewRepository.findOneById(Member.id, lisenceNumber) == true ? "O" : "X";
				
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
		}
	}

	private ArrayList<Reservation> findAllRerservation(String id) {
		ArrayList<Reservation> tmp = new ArrayList<Reservation>();
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id) && !(r.getState().equals("예약"))) {
					tmp.add(r);
			}
		}
		return tmp;
	}

}
