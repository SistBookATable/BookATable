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
import com.test.java.view.UserWriteReviewView;
import com.test.java.view.View;

/**
 * UserWriteReviewController는 사용자의 리뷰 작성에 관련된 기능을 처리하는 클래스입니다.
 */
public class UserWriteReviewController {
	
	/**
     * 사용자에게 리뷰 작성 기회를 제공하고 작성된 리뷰를 저장하는 메서드입니다.
     * @param reservations 사용자의 예약 목록
     */
	public void userWriteReview(ArrayList<Reservation> reservations) {
		ArrayList<Reservation> noReviewReservation = findAllNoReviewReservation(reservations, Member.id);

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

		for (Reservation r : noReviewReservation) {
			UserWriteReviewView.showOneReserVation(r,storeName, cancelState, noShowState, reviewState);
			StoreRepository.findOneByLicenseNumber(r.getLicenseNumber()).getStoreName();
		}

		int reservationNumber = UserWriteReviewView.getReservationNumber();

		Reservation selected = isValid(reservationNumber, reservations);

		if (selected == null) {
			UserWriteReviewView.incorrectReservationNumber();
			return;
		}

		if (ReviewRepository.findOne(reservationNumber) != null) {
			UserWriteReviewView.alreadyHasReview();
			return;
		}

		String lisenceNumber = selected.getLicenseNumber();
		double score = UserWriteReviewView.getReviewScore();
		String reviewContent = UserWriteReviewView.getReviewContent();

		Calendar cur = Calendar.getInstance();
		String today = String.format("%tF", cur);

		ReviewRepository.add(0, Member.id, lisenceNumber, today, reviewContent, score, reservationNumber);

		UserWriteReviewView.showCompleteMessage();

	}
	
	 /**
     * 사용자가 입력한 예약 번호가 유효한지 확인하는 메서드입니다.
     * @param reservationNumber 사용자가 입력한 예약 번호
     * @param reservations 사용자의 예약 목록
     * @return 선택된 예약 정보
     */
	private String findReviewState(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	private String findCancelState(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	private String findNoShowState(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	private String findStoreName(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	private Reservation isValid(int reservationNumber, ArrayList<Reservation> reservations) {

		for (Reservation r : reservations) {
			if (r.getReservationNumber() == reservationNumber) {
				return r;

			}

			String userName = findNameById(Member.id);
			UserWriteReviewView.showNoReviewReservation(userName);
			//noReviewReservation 추가
			ArrayList<Reservation> noReviewReservation = findAllNoReviewReservation(reservations, Member.id);
			ArrayList<Integer> stringArr = new ArrayList<>();
			for (Reservation rv : noReviewReservation) {
				String storeName = StoreRepository.findNameOneByLicenseNumber(r.getLicenseNumber());
				stringArr.add(rv.getReservationNumber());
				String cancelState = rv.getState().equals("취소") == true ? "O" : "X";
				String noShowState = rv.getState().equals("노쇼") == true ? "O" : "X";
				String reviewState = ReviewRepository.findOneById(Member.id, rv.getLicenseNumber()) == true ? "O" : "X";
				UserWriteReviewView.showOneReserVation(rv, storeName, cancelState, noShowState, reviewState);
			}

			int inputReservationNumber = UserWriteReviewView.getReservationNumber();
			if (stringArr.contains(inputReservationNumber)) {
				String reviewContent = UserWriteReviewView.getReviewContent();
				double score = UserWriteReviewView.getReviewScore();
				addReview(reviewContent, inputReservationNumber, score);
				System.out.println("리뷰 작성이 완료되었습니다.");
				View.pause();
//				loop = false;
			}
		}
		return null;
	}

	private void addReview(String reviewContent, int reservationNumber, double score) {
		int reviewNumber = Data.reviewList.size() + 1;
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		String dateWritten = dateformat.format(c.getTime());
		String userId = "";
		String licenseNumber = "";
		for (Reservation r : Data.reservationList) {
			if (r.getReservationNumber() == reservationNumber) {
				userId = r.getUserId();
				licenseNumber = r.getLicenseNumber();
			}
		}

		Review newReview = new Review(reviewNumber, userId, licenseNumber, dateWritten, reviewContent, score,
				reservationNumber);
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

		for (Reservation r : reservations) {
			if (r.getUserId().equals(id) && r.getState().equals("방문")) {
				if (!ReviewRepository.findOneById(Member.id, r.getLicenseNumber())) {
					tmp.add(r);
				}
			}
		}
		return tmp;
	}

}
