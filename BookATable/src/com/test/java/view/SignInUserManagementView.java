package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;

public class SignInUserManagementView {

	public static void findAllUser() {

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
		View.pause();
	}

	public static void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 상세 내역 조회              ■");
		System.out.println("■           0. 뒤로 가기                  ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
	}
	

	public static int getSelectType() {
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		scan.nextLine();
		return tmp;
	}

	public static String getId() {
		System.out.println("확인할 회원의 아이디를 입력하세요");
		System.out.print("선택(회원ID) : ");

		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		return tmp;
	}

	public static void show(String basic) {
		System.out.println();
		System.out.println(basic);
		System.out.println();
	}

}
