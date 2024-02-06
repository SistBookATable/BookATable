package com.test.java.view;

import java.util.Scanner;

public class AddBlackListView {

	public void showSelectBox() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 블랙리스트 등록       \t■");
		System.out.println("■           0. 뒤로 가기           \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
	}
	
	public int getSelectType() {
		return View.getSelectType();
	}
	
	public void incorrectInputMessgae() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("    (1, 0) 중에 하나를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}


	public void showUserIdInputBox() {
		System.out.println();
		System.out.println("블랙리스트 등록할 아이디를 입력해주세요");
		System.out.print("선택(ID) : ");
		
	}
	public String getUserId() {
		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		return tmp;
	}
	
	public void incorrectUserIDMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("  위의 리스트에 있는 사용자 ID를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}

	public void alreadyBlackListMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        이미 블랙리스트에 등록된 회원입니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}

	public void successMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        블랙리스트로 등록 되었습니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}

}
