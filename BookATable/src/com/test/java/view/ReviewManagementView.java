package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Review;

public class ReviewManagementView {

	public void show(Review selected, String reason) {
		
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|        리뷰 관리 - 리뷰 삭제 요청 조회 - 리뷰 내용 보기         <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String basic = String.format("작성일 : %s\n문의자 : %s\n요청사유 : %s",
				selected.getDateWritten(),
				selected.getLicenseNumber(),
				reason);
		
		System.out.println(basic);
		System.out.println("───────────────────────────────────────────────────────");
		System.out.println("                        리뷰 내용");
		System.out.println("───────────────────────────────────────────────────────");
		System.out.println(selected.getContent());
		System.out.println();
		
	}

	public void showSelectBox() {
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 리뷰 삭제                  ■");
		System.out.println("■           2. 요청 거부                  ■");
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

	public void deleteSuccessMessage() {
		System.out.println();
		System.out.println("요청하신 리뷰가 삭제되었습니다.");
		System.out.println();
		View.pause();
		
		
	}

}
