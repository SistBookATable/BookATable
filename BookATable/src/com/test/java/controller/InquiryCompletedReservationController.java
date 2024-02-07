package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.repository.ReservationRepository;
import com.test.java.repository.ReviewRepository;
import com.test.java.repository.StoreRepository;
import com.test.java.view.InquiryCompletedReservationView;
import com.test.java.view.View;

public class InquiryCompletedReservationController {
/*
 [예약일]	     [상호명]	     		[인원수]	  [예약취소여부]	    [노쇼여부]			[리뷰작성여부]	
 2023-12-29	 이조식당					5명			X				O				null	
 2023-12-29	 (주)정성담에프앤비			8명			X				O				null	
 2023-12-29	 지하오					3명			X				O				null	
 2023-12-29	 이조식당					5명			X				X				null	
 2023-12-29	 이조식당					8명			X				X				null	
 2023-12-29	 이조식당					6명			X				X				null	
 2023-12-29	 이조식당					5명			X				X				null	
 2023-12-29	 이조식당					10명			X				X				null	
 2023-12-29	 이조식당					7명			X				X				null	
 2023-12-29	 이조식당					2명			O				X				null	
*/
	
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
			
			// ID로 예약조회
			ArrayList<Reservation> reservations = ReservationRepository.findAllById(Member.id);
			
			// 출력
			for(Reservation r : reservations) {
				//라이센스 번호
				String lisenceNumber = r.getLicenseNumber();
				
				//상호명
				String storeName = StoreRepository.findNameOneByLicenseNumber(lisenceNumber);
				
				String state = r.getState();
				
				String cancelState = state.equals("취소")?"O":"X";
				String noShowState = state.equals("노쇼")?"O":"X";
				
				String reviewState = ReviewRepository.findOneById(Member.id, lisenceNumber)==true? "O":"X";
				
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
		for(Reservation reservation : Data.reservationList) {
			if (reservation.getUserId().equals(id)) {
				for(Review review : Data.reviewList) {
					if (review.getUserId().equals(id) && review.getContent().equals(null)) {
						String reviewState = review.getContent().equals(null) ? "O" : "X";
						return reviewState;
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
			if (r.getUserId().equals(id) && !r.getState().equals("취소")) {
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
