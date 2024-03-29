package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.ReviewRepository;
import com.test.java.repository.StoreRepository;
import com.test.java.view.InquiryCompletedReservationView;
/**
 * InquiryCompletedReservationController는 완료된 예약의 목록을 호출하고, 리뷰를 작성에 관여하는 클래스입니다.
 */
public class InquiryCompletedReservationController {

	/**
     * 완료된 예약을 조회하는 메서드입니다.
     * 또한, 사용자의 입력에 따라서 리뷰 작성 컨트롤러를 호출하여 리뷰작성 화면으로 이동할 수 있습니다.
     */
	public void inquiryCompletedReservation() {
		boolean loop = true;
		while (loop) {
			// 회원의 완료된 예약 목록 조회
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
				String reviewState = ReviewRepository.findOne(r.getReservationNumber()) != null ? "O" : "X";

				
				InquiryCompletedReservationView.showOneReservation(r, storeName, cancelState, noShowState, reviewState);
			}
			
			InquiryCompletedReservationView.showSelecBox();
			int choice = InquiryCompletedReservationView.get();
			
			switch (choice) {
			case 1:
				// 리뷰 작성 컨트롤러 호출
				UserWriteReviewController userWriteReviewController = new UserWriteReviewController();
				userWriteReviewController.userWriteReview(visitedList);
				break;
			case 0 :
				loop = false;
				break;
			}
		}
	}

	 /**
     * 회원의 모든 예약목록 조회하여 완료된 예약 목록만을 반환하는 메서드입니다.
     *
     * @param id 회원 ID
     * @return 완료된 예약 목록
     */
	private ArrayList<Reservation> findAllRerservation(String id) {
		ArrayList<Reservation> tmp = new ArrayList<Reservation>();
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id) && !r.getState().equals("예약")) {
				tmp.add(r);
			}
		}
		return tmp;
	}

}