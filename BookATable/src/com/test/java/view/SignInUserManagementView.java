package com.test.java.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.User;
import com.test.java.repository.Data;

public class SignInUserManagementView {

	public void findAllUser() {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                  회원 관리 - 가입 회원 조회                <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%15s%15s%18s%15s%15s%15s", "[회원ID]","[가입일]","[회원 이름]","[예약 횟수]","[노쇼 횟수]","[정지 여부]");
		System.out.println(header);
		
		for(Member m : Data.memberList) {
			String tmp = "";
			if(m.getUserType() == 1) {
				tmp = String.format("%15s%18s%15s%15d회%15d회%19s", 
						m.getId(),
						m.getSignIn(),
						m.getName(),
						((User)m).getReservationCount(),
						((User)m).getNoshowCount(),
						(((User)m).getNoshowCount() >= 10)? "정지회원입니다.":" ");
				System.out.println(tmp);
			}
			
		}
	}

	public void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 상세 내역 조회              ■");
		System.out.println("■           0. 뒤로 가기                  ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
	}
	

	public int getSelectType() {
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		scan.nextLine();
		return tmp;
	}

	public String getId() {
		System.out.println("확인할 회원의 아이디를 입력하세요");
		System.out.print("선택(회원ID) : ");

		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		return tmp;
	}

	public void show(String basic) {
		System.out.println();
		System.out.println(basic);
		System.out.println();
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

	public void incorrectInputMessage() {
		System.out.println();
		System.out.println("잘못된 id입니다.");
		System.out.println();
		
		View.pause();
	}

	public void showDetailCard(ArrayList<Reservation> reservations) {		

		
	}

}
