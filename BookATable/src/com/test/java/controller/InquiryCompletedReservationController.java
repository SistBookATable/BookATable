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
			
			String userName = MemberRepository.findOneById(Member.id).getName();
			InquiryCompletedReservationView.showTitle(userName);
			
			// ID로 예약조회
			
			// 출력
			for(Reservation r : visitedList) {
				//라이센스 번호
				String lisenceNumber = r.getLicenseNumber();
				
				//상호명
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
			View.pause();
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
