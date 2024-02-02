package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.SignInUserManagementView;
import com.test.java.view.View;

public class SignInUserManagementController {

	public void signInUserManagement() {
		
		
		boolean loop = true;
		while(loop) {

			SignInUserManagementView.findAllUser();
			SignInUserManagementView.showSelectBox();
			int choice = SignInUserManagementView.getSelectType();
			
			if(choice == 1) {
				//아이디 입력 받기
				String id = SignInUserManagementView.getId();
				//아이디를 사용해서 기본정보 받아오기
				String basic = findBasicById(id);
				//기본 정보 출력
				SignInUserManagementView.show(basic);
				
				//아이디를 사용해서 세부 예약 내역을 찾고 출력
				findDetailById(id);
				
				
			}
			else if(choice == 0) {
				loop = false;
			}
			
		}
	}

	private String findBasicById(String id) {
		String tmp = "";
		for(Member m : Data.memberList) {
			if(m.getId().equals(id)) {
				tmp += "\t회원명 : " + m.getName() +"\n";
				tmp += "\t회원ID : " + m.getId() +"\n";
				tmp += "\t예약 횟수 : " + ((User)m).getReservationCount() +"\n";
				tmp += "\t노쇼 횟수 : " + ((User)m).getNoshowCount() +"\n";
				break;
			}
		}
		return tmp;
	}

	private void findDetailById(String id) {
		
		boolean hasHistory = false;
		
		for(Reservation r : Data.reservationList) {
			if(r.getUserId().equals(id)) {
				hasHistory = true;
				
				int reservationNumber = r.getReservationNumber();
				String storeName = findName(r.getLicenseNumber());
				String date = r.getReservationDate();
				int numOfPeople = r.getNumOfPeople();
				ArrayList<String> menulist = r.getMenulist();
				
				double score = findScore(id);
				String content = findContent(id);
				
				SignInUserManagementView.showDetail(reservationNumber, storeName,date,numOfPeople,menulist,score,content);
			}
		}
		
		if(!hasHistory) {
			SignInUserManagementView.show("이용 내역을 찾을 수 없습니다.");
		}
		
		View.pause();
		
	}

	private String findContent(String id) {
		for(Review r :Data.reviewList) {
			if(r.getUserId().equals(id)){
				return r.getContent();
			}
		}
		return null;
	}

	private double findScore(String id) {
		for(Review r :Data.reviewList) {
			if(r.getUserId().equals(id)){
				return r.getScore();
			}
		}
		return 0;
	}

	private String findName(String licenseNumber) {
		for(Store s : Data.storeList) {
			if(s.getLicenseNumber().equals(licenseNumber)) {
				return s.getStoreName();
			}
		}
		return null;
	}

}