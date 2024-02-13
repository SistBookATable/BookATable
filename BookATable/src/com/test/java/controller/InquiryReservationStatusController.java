package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.InquiryReservationStatusView;
import com.test.java.view.View;

/**
 * 사용자의 예약 현황을 조회하는 컨트롤러 클래스입니다.
 */
public class InquiryReservationStatusController {
	
	/**
     * 사용자의 예약 현황을 조회하는 메서드입니다.
     */
	public void inquiryReservationStatus() {

		boolean loop = true;
		while (loop) {
			
			ArrayList<Reservation> userReservationList = findAllReservation(Member.id);// 사용자의 모든 예약 정보를 가져옴

			String userName = findNameById(Member.id);// 사용자 이름을 아이디로부터 찾음
			InquiryReservationStatusView.showUserReservationHeader(userName);// 사용자의 실시간 예약현황을 보여줌

			if (userReservationList.isEmpty()) {
				// 예약이 없을 경우 메시지를 표시하고 반복문 종료
				InquiryReservationStatusView.showNoReservationMessage();
				loop = false;
			}

			for (Reservation r : userReservationList) {
				// 예약 정보와 일치하는 사업자번호로 음식점 이름을 찾음
				String storeName = findStoreNameByLisenceNumber(r.getLicenseNumber());
				// 단일의 실시간 예약정보와 음식점 이름을 함께 표시
				InquiryReservationStatusView.showOneReservation(r, storeName);
			}

			// 메뉴 선택 입력란 출력 후 입력 받은 값을 가져옴
			InquiryReservationStatusView.showSelectBox();
			int choice = InquiryReservationStatusView.get();

			switch (choice) {
			case 1:
				// 예약 취소 컨트롤러를 생성하여 예약 취소 메서드 호출
				ReservationCancelController reservationCancelController = new ReservationCancelController();
				reservationCancelController.reservationCancel();
				break;
			case 0:
				loop = false;
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 사업자등록번호로 상저이름을 찾는 메서드입니다.
	 * @param licenseNumber
	 * @return 조건문이 true면 음식점이름 반환, false면 null 반환
	 */
	private String findStoreNameByLisenceNumber(String licenseNumber) {
		for (Store s : Data.storeList) {
			if (s.getLicenseNumber().equals(licenseNumber)) {
				return s.getStoreName();
			}
		}
		return null;
	}
	
	
	/**
	 * 아이디로 모든 예약 정보를 찾는 메서드입니다.
	 * @param id
	 * @return ArrayList<Reservation> tmp
	 */
	private ArrayList<Reservation> findAllReservation(String id) {
		ArrayList<Reservation> tmp = new ArrayList<>();
		for (Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id) && r.getState().equals("예약")) {
				tmp.add(r);
			}
		}

		return tmp;
	}

	/**
	 * 아이디로 회원의 이름을 찾는 메서드입니다.
	 * @param id
	 * @return 조건문 true면 회원이름, false면 null
	 */
	private String findNameById(String id) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getName();
			}
		}
		return null;

	}

}