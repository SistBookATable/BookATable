package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.repository.Data;
import com.test.java.view.ReservationView;

public class ReservationController {
	
	private ReservationView reservationView = new ReservationView();
	private ArrayList<Reservation> reservation;
	
	public void reservation() {
			
			int num=reservationView.getReservationNum();
			String date=reservationView.getReservationDate();
			String time=reservationView.getReservationTime();
			String menu=reservationView.getReservationMenu(); 
			
			reservationView.showReservation(num, date, time, menu);
		
	}

	public void BusinessUserReservationManagement() {
		
		String lisenceNumber = "";
		boolean loop = true;
		while(loop) {

			reservationView.showTitle();
			reservationView.showSelectBox();
			int choice = reservationView.getSelectType();
			
			switch (choice) {
			
			//예약 현황 조회
			case 1: 
				
				//업체회원 ID로 음식점 라이센스번호 조회
				lisenceNumber = findLisenceNumber(Member.id);
				
				//라이센스번호로 현재 예약상태인 모든 예약 조회
				ArrayList<Reservation> cur = findAllReservation(lisenceNumber,"예약");
				
				//현재 예약이 없을 때
				if(cur.isEmpty()) {
					reservationView.showNoCurrentResevationMessage();
					break;
				}
				
				//예약리스트 출력
				reservationView.showReservationList(cur);
				break;
				
			// 방문 고객 조회
			case 2:  

				//업체회원 ID로 음식점 라이센스번호 조회
				lisenceNumber = findLisenceNumber(Member.id);

				//라이센스번호로 고객이 방문했던 모든 예약 조회
				ArrayList<Reservation> visited = findAllReservation(lisenceNumber);
				
				//방문 기록이 없을 때
				if(visited.isEmpty()) {
					reservationView.showNoResevationHistoryMessage();
					break;
				}
				
				//방문 리스트 출력
				reservationView.showVistedReservationHeader();
				for(Reservation r : visited) {
					String name = findUserName(r.getUserId());
					reservationView.showOneReservation(r, name);
				}
				break;
			case 0:
				loop = false;
				break;
			default:
				break;
			}
		}
		
	}

	private ArrayList<Reservation> findAllReservation(String lisenceNumber) {
		
		ArrayList<Reservation> tmp = new ArrayList<>();
		
		for(Reservation r : Data.reservationList) {
			
			if(r.getLicenseNumber().equals(lisenceNumber)) {
				tmp.add(r);
			}
		}
		
		return tmp;
	}

	private String findUserName(String userId) {
		for(Member m : Data.memberList) {
			if(m.getId().equals(userId)) {
				return m.getName();
			}
		}
		return null;
	}

	private String findLisenceNumber(String id) {
		for(Member m : Data.memberList) {
			if(m.getId().equals(id)) {
				return ((BusinessUser)m).getLicenseNumber();
			}
		}
		return null;
	}

	private ArrayList<Reservation> findAllReservation(String lisenceNumber,String state) {
		
		ArrayList<Reservation> tmp = new ArrayList<>();
		
		for(Reservation r : Data.reservationList) {
			
			if(r.getLicenseNumber().equals(lisenceNumber) && r.getState().equals(state)) {
				tmp.add(r);
			}
		}
		
		return tmp;
	}
	
	

}
