package com.test.java.controller;

import java.util.Calendar;
import java.util.HashMap;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.Menu;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.RevenueManagementView;

public class RevenueManagementController {

	public void revenueManagement() {
		


		RevenueManagementView revenueManagementView = new RevenueManagementView();
		String lisenceNumber = "";
		
		boolean loop = true;
		while(loop) {
			
			revenueManagementView.showTitle();
			revenueManagementView.showSelectBox();
			int choice = revenueManagementView.getSelectType();
			
			switch(choice) {

			case 1:
				//예상 매출 조회
				revenueManagementView.showCase1Title();
				
				//업체회원 ID로 음식점 라이센스번호 조회
				lisenceNumber = findLisenceNumber(Member.id);

				//라이센스번호로 음식점 이름 조회
				String name = findNameNumber(lisenceNumber);
				
				//오늘 날짜 구하기
				Calendar cur = Calendar.getInstance();
				String today = String.format("%tF", cur);

				//메뉴 개수를 저장할 HashMap 생성
				HashMap<String, Integer> menuCount = new HashMap<>();
				
				//오늘 예약내역 중 노쇼,취소를 제외한 내역의 메뉴 개수 구하기
				findMenuCount(lisenceNumber, today, menuCount);
				
				//내역이 없을 경우
				if(menuCount.isEmpty()) {
					revenueManagementView.hasNoHistoryMessage();
					continue;
				}
					
				//예상 매출 합산
				int revenue = calcRevenue(lisenceNumber,menuCount);
				
				revenueManagementView.showRevenue(revenue, today, name);
				break;
			case 2:
				//정산 예약금 조회
				revenueManagementView.showCase2Title();
				
				break;
			case 0:
				loop = false;
				break;
			default:
				loop = false;
			}
			
		}
		
		
	}
	
	private String findNameNumber(String lisenceNumber) {
		for(Store s : Data.storeList) {
			if(s.getLicenseNumber().equals(lisenceNumber)) {
				return s.getStoreName();
			}
		}
		return null;
	}

	private int calcRevenue(String lisenceNumber, HashMap<String, Integer> menuCount) {
		
		int sum = 0;
		
		for(Menu m : Data.menuList) {
			if(m.getLicenseNumber().equals(lisenceNumber)) {
				for(String key : menuCount.keySet()) {
					if(m.getMenuName().equals(key)) {
						sum += menuCount.get(key) * m.getPrice();
					}
				}
			}
		}
		return sum;
	}

	private void findMenuCount(String lisenceNumber, String today, HashMap<String, Integer> menuCount) {
		
		for(Reservation r : Data.reservationList) {
			if(r.getLicenseNumber().equals(lisenceNumber) && r.getReservationDate().equals(today)) {
				if(r.getState().equals("노쇼") || r.getState().equals("취소")) {
					continue;
				}
				for(String name : r.getMenulist()) {
					if(menuCount.containsKey(name)) {
						menuCount.put(name,	menuCount.get(name)+1);	
					}
					else {
						menuCount.put(name,1);
					}
				}
			}
		}
		
	}

	private String findLisenceNumber(String id) {
		for(Member m : Data.memberList) {
			if(m.getId().equals(id)) {
				return ((BusinessUser)m).getLicenseNumber();
			}
		}
		return null;
	}

}
