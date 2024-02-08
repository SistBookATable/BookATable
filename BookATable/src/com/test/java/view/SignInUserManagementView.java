package com.test.java.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.User;
import com.test.java.repository.Data;

public class SignInUserManagementView {

	public void showAllUser(ArrayList<Member> memberList, int cur) {

		String header = String.format("%s\t%15s%15s%18s%15s%15s%15s","[회원]", "[회원ID]","[가입일]","[회원 이름]","[예약 횟수]","[노쇼 횟수]","[정지 여부]");
		System.out.println(header);
		
		for(int i=0; i<10; i++) {
			if(cur+i == memberList.size()) {
				break;
			}
			memberList.get(cur+i).printSignIn();
		}
	}

	public void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 이전 페이지            \t■");
		System.out.println("■           2. 다음 페이지            \t■");
		System.out.println("■           3. 상세 내역 조회          \t■");
		System.out.println("■           0. 뒤로 가기              \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
	}
	

	public int getSelectType() {
		return View.getSelectType();
	}

	public String getId() {
		System.out.println("확인할 회원의 아이디를 입력하세요");
		System.out.print("선택(회원ID) : ");

		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		return tmp;
	}

	public void showBasic(String basic) {
		System.out.println();
		System.out.println(basic);
		System.out.println();
		
		View.pause();
	}
	
	public void show(String basic) {
		System.out.println();
		System.out.println(basic);
		System.out.println();
		
		View.pause();
	}

	public void showDetail(int reservationNumber, String storeName, String date, int numOfPeople,
			HashMap<String, Integer> menuCount, double score, String content) {
		

		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|\t[예약 번호\t] " + reservationNumber);
		System.out.println("|\t[ 음식점 \t] " + storeName);
		System.out.println("|\t[ 예약일 \t] " + date);
		System.out.println("|\t[ 인원수 \t] " + numOfPeople + "명");
		System.out.print("|\t[  메뉴  \t] ");
		for(String key : menuCount.keySet()) {
			System.out.print(key +" "+ menuCount.get(key)+"개, ");
		}
		System.out.print("\n");
		System.out.println("|\t[  별점  \t] " + score);
		System.out.println("|\t[  리뷰  \t] " + content);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
	}

	public void showDetailTitle() {
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|          회원 관리 - 가입 회원 조회 - 상세 내역 조회           <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
	}

	public void incorrectIdMessage() {
		System.out.println();
		System.out.println("잘못된 id입니다.");
		System.out.println();
		
		View.pause();
	}

	public void showDetailCard(ArrayList<Reservation> reservations) {		

		
	}

	public void showTitle() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                  회원 관리 - 가입 회원 조회                <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
	}

	public void incorrectInputMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("     (1, 0) 중에 하나를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}

	public void firstPageMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("       첫 번째 페이지 입니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
	}

	public void lastPageMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("       마지막 페이지 입니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
	}

}
