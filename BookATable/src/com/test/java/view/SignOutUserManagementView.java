package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;

public class SignOutUserManagementView {

	public void findAllSignOutUser() {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                  회원 관리 - 탈퇴 회원 조회                <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%15s%18s%15s%15s%15s%15s", "[회원ID]","[회원 이름]","[예약 횟수]","[노쇼 횟수]","[탈퇴일]","[정지 여부]");
		System.out.println(header);
		
		for(Member m : Data.memberList) {
			String tmp = "";
			if(m.getUserType() == 1 && !((User)m).getSignOut().equals("null")) {
				tmp = String.format("%15s%17s%15d회%15d회%19s%15s", 
						m.getId(),
						m.getName(),
						((User)m).getReservationCount(),
						((User)m).getNoshowCount(),
						((User)m).getSignOut(),
						(((User)m).getNoshowCount() >= 10)? "정지회원":" ");
				System.out.println(tmp);
			}
			
		}
		
		
	}

	public void showSelectBox() {
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 회원 정보 삭제              ■");
		System.out.println("■           0. 뒤로 가기                  ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
		
	}

	public static void deleteCancleMessage() {
		System.out.println();
		System.out.println("탈퇴후 30일이 경과하지 않아서 삭제할 수 없습니다.");
		System.out.println();
		View.pause();
	}

	public static void deleteSuccessMessage() {
		System.out.println();
		System.out.println("회원 정보가 삭제되었습니다.");
		System.out.println();
		View.pause();
		
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

}
