package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.ReservationCancelView;
import com.test.java.view.View;

public class ReservationCancelController {
	public void reservationCancel() {
		ReservationCancelView.showReservationCancel();
//		oknexuf
//		hsbmt@
//		한옥집 김치찜 GFC몰점	

		boolean loop = true;
		while (loop) {
			if (ReservationCancelView.get().equalsIgnoreCase("Y")) {
				System.out.println("예약을 취소하시겠습니까?");
				
				//예약 취소할 상호명 입력받기
				String inputStoreName = ReservationCancelView.getStoreName();
				
				//입력받은 상호명으로 해당 음식점의 라이센스넘버 찾기
				String lisenceNumber = findLicenseNumber(inputStoreName, Member.id);
				
				//라이센스번호로 유저의 모든 예약 조회
				ArrayList<Reservation> userReservationList = findAllReservation(lisenceNumber);
				
				//입력받은 상호명의 라이센스 넘버와 일반회원의 예약의 라이센스 넘버가 같은지 확인 
				boolean isValidLisenceNumber = checkLisenceNumber(lisenceNumber, Member.id);
				
				if (userReservationList.isEmpty()) {
					ReservationCancelView.showNoReservationHistoryMessage();
					loop = false;
				}
				
				//일치할 때, 예약 상태 "취소"로 변경
				if (isValidLisenceNumber) {
					modifyReservationState(lisenceNumber, Member.id);
					System.out.println("예약이 취소되었습니다.");
					loop = false;
				}

				break;
			} else if (ReservationCancelView.get().equalsIgnoreCase("N")) {
				System.out.println("예약 취소 과정을 중지합니다.");
				View.pause();
				break;
			}
			loop = false;

		}
	}

	private ArrayList<Reservation> findAllReservation(String lisenceNumber) {
		ArrayList<Reservation> tmp = new ArrayList<Reservation>();
		for(Reservation r : Data.reservationList) {
			if (r.getLicenseNumber().equals(lisenceNumber)) {
				tmp.add(r);
			}
		}
		
		return tmp;
	}

	private void modifyReservationState(String lisenceNumber, String id) {
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				r.setState("취소");
			}
		}
		
	}

	private boolean checkLisenceNumber(String lisenceNumber, String id) {
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				if (r.getLicenseNumber().equals(lisenceNumber)) {
					return true;
				}
			}
		}
		return false;
	}

	private String findLicenseNumber(String inputStoreName, String id) {
		for(Store s : Data.storeList) {
			if (s.getStoreName().equals(inputStoreName)) {
				return s.getLicenseNumber();
			}
		}
		return null;
	}

}
