package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Review;

public class BusinessUserReviewView {

	public void showReviewHeader() {
		
		String header = String.format("%15s\t%7s\t%7s\t%-20s", "[리뷰 작성일]","[리뷰 번호]","[작성자]","[리뷰 내용]");
		System.out.println(header);
		
	}

	public void showSelectBox() {
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■            1. 다음 페이지        \t■");
		System.out.println("■            2. 이전 페이지        \t■");
		System.out.println("■            3. 리뷰 삭제 요청      \t■");
		System.out.println("■            0. 이전 화면	         \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
		
	}

	public int getSelectType() {
		return View.getSelectType();
	}

	public void showReview(Review r) {
		System.out.printf("%17s\t%7s\t\t%7s\t\t%-20s\n",r.getDateWritten(),r.getReviewNumber(),r.getUserId(),r.getContent());
		
	}

	public void lastPageMessage() {
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        마지막 페이지 입니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
	}

	public void firstPageMessage() {
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        첫 페이지 입니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
	}

	public int getReviewNumber() {
		return View.getSelectType();
	}

	public void showReviewNumberInputBox() {
		System.out.println();
		System.out.println("삭제할 리뷰 번호를 입력해주세요");
		System.out.print("선택(번호) : ");
		
	}
	public void incorrectReviewNumberMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("  위의 리스트에 있는 리뷰 번호(숫자)를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}
	public void incorrectInputMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("     (1, 2, 3, 0)중에서 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}

	public void showInputReasonBox(String string) {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("  " + string+"님이 입력한 리뷰의 삭제 요청을 진행합니다." );
		System.out.println("        삭제 요청 사유를 입력해주세요");
		System.out.println("     삭제 요청 취소를 원하시면 숫자(\'0\')를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("요청 사유 : ");
	}

	public String getReason() {
		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		return tmp;
	}

	public void hasNoHistory() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        등록된 리뷰가 없습니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}

	public void requestSuccessMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        리뷰 삭제 요청이 전송되었습니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
	}

	public void alreadyHasRequest() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        이미 삭제 요청된 리뷰입니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
	}

}
