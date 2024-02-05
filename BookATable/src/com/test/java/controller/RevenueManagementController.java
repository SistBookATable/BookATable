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
		String storeName = "";
		
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
				storeName = findNameNumber(lisenceNumber);
				
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
				
				revenueManagementView.showRevenue(revenue, today, storeName);
				break;
			case 2:
				//정산 예약금 조회
				revenueManagementView.showCase2Title();

				//업체회원 ID로 음식점 라이센스번호 조회
				lisenceNumber = findLisenceNumber(Member.id);

				//업체회원 ID로 이름 조회
				String userName = findUserName(Member.id);
				
				//라이센스번호로 음식점 이름 조회
				storeName = findNameNumber(lisenceNumber);

				//오늘, 이번달 1일 구하기
				Calendar date = Calendar.getInstance();
				today = String.format("%tF", date);
				date.set(Calendar.DATE, 1);
				String firstDay = String.format("%tF", date);
				
				//이번달 1일 이후 예약 개수 구하기 (노쇼, 방문 상태인 예약만)
				int reservationCount = getReservationCount(firstDay,lisenceNumber);
				
				revenueManagementView.showDeposit(firstDay, today, storeName, userName, reservationCount*3000);
				
				break;
			case 0:
				loop = false;
				break;
			default:
				loop = false;
			}
			
		}
		
		
	}
	
	private String findUserName(String id) {
		for(Member m : Data.memberList) {
			if(m.getId().equals(id)) {
				return m.getName();
			}
		}
		return null;
	}

	private int getReservationCount(String firstDay, String lisenceNumber) {
		int cnt = 0;
		for(Reservation r : Data.reservationList) {
			if(r.getLicenseNumber().equals(lisenceNumber)) {
				if(r.getState().equals("취소") || r.getState().equals("예약")) {
					continue;
				}
				if(isValid(r.getReservationDate(), firstDay)) {
					System.out.println(r.getReservationNumber());
					cnt++;
				}
			}
		}
		return cnt;
	}

	private boolean isValid(String reservationDate, String firstDay) {
		int ryear = Integer.parseInt(reservationDate.split("-")[0]);
		int rmonth = Integer.parseInt(reservationDate.split("-")[1]);
		int rday = Integer.parseInt(reservationDate.split("-")[2]);
		
		int fyear = Integer.parseInt(firstDay.split("-")[0]);
		int fmonth = Integer.parseInt(firstDay.split("-")[1]);
		int fday = Integer.parseInt(firstDay.split("-")[2]);
		
		if(ryear < fyear) {
			return false;
		}
		else if(rmonth < fmonth) {
			return false;
		}
		else if(rday < fday) {
			return false;
		}
		return true;
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
