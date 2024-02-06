package com.test.java.view;

public class BusinessUserBookmarkView {

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
		System.out.println("■            1. 등록 리뷰 조회       \t■");
		System.out.println("■            2. 즐겨찾기 조회        \t■");
		System.out.println("■            3. 고객 관리 	         \t■");
		System.out.println("■            0. 이전 화면	         \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
		
		
	}


	public int getSelectType() {
		return View.getSelectType();
	}


	public void showBookMarkCount(String storeName, int count) {
		System.out.println("■■■■■■■■■■■■■■■■ " + storeName + "은 ■■■■■■■■■■■■■■■■");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.printf("\t             %,d회 \n",count);
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("\t즐겨찾기 매장으로 등록되었습니다.");
		
		View.pause();
		
	}
}
