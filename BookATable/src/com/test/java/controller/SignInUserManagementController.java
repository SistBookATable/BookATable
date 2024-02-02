package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.SignInUserManagementView;

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
				
				//아이디를 사용해서 세부 예약 내역 정보 받아오기
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
		ArrayList<String> temp = new ArrayList<>();
		ArrayList<Reservation> tmp = new ArrayList<>();
		for(Reservation r : Data.reservationList) {
			if(r.getUserId().equals(id)) {
				tmp.add(r);
				int reservationNumber = r.getReservationNumber();
				String storeName = findName(r.getLicenseNumber());
				String date = r.getReservationDate();
				int numOfPeople = r.getNumOfPeople();
				ArrayList<Menu> = r.getMenu();
				
				
			}
		}
		
	}

}
