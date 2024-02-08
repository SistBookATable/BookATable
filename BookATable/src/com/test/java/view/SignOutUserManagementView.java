package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;

public class SignOutUserManagementView {

	public void showAllSignOutUser(ArrayList<Member> userList, int cur) {
		
		String header = String.format("%s\t%18s%18s%15s%15s%15s%15s", "[회원타입]","[회원ID]","[회원 이름]","[예약 횟수]","[노쇼 횟수]","[탈퇴일]","[정지 여부]");
		System.out.println(header);
		for(int i=0; i<10; i++) {
			if(cur+i == userList.size())
				break;
			userList.get(cur+i).print();
		}
	}

	public void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 이전 페이지            \t■");
		System.out.println("■           2. 다음 페이지            \t■");
		System.out.println("■           3. 회원 정보 삭제          \t■");
		System.out.println("■           0. 뒤로 가기              \t■");
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
		return View.getSelectType();
	}

	public String getId() {
		System.out.println("확인할 회원의 아이디를 입력하세요");
		System.out.print("선택(회원ID) : ");

		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		return tmp;
	}

	public void showTitle() {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                  회원 관리 - 탈퇴 회원 조회                <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
	}

	public void incorrectInputMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("      (1,2,3,0) 중에 하나를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}

	public void incorrectIdMessage() {
		
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("      위의 리스트에 있는 ID를 입력해주세요");
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
