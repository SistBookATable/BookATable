package com.test.java.view;

public class CustomerManagementView {

	public void showTitle() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                  업체 회원 - 즐겨찾기 조회                  <");
		System.out.println("└───────────────────────────────────────────────────────┘");
	}
	public void showSelectBox() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■            1. 단골 고객 관리       \t■");
		System.out.println("■            2. 블랙리스트 관리      \t■");
		System.out.println("■            0. 이전 화면	         \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
		
		
	}
	public int getSelectType() {
		return View.getSelectType();
	}
	public void incorrectInputMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("     (1, 2, 0) 중에 하나를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
	}
	

}
