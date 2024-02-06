package com.test.java.view;

public class SalesManagementView {

	public void showTitle() {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                    업체 회원 - 영업 관리                  <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		
		
	}

	public void showSelectBox() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■            1. 등록 리뷰 조회       \t■");
		System.out.println("■            2. 즐겨찾기 조회        \t■");
		System.out.println("■            3. 고객 관리 	         \t■");
		System.out.println("■            0. 이전 화면	         \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
		
		
	}

	public int getSelectType() {
		return View.getSelectType();
	}

	public void incorrectInputMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("    (1, 2, 3, 0) 중에 하나를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}





}
