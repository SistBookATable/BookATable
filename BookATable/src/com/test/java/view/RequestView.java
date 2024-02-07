package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Request;
import com.test.java.model.Review;
import com.test.java.repository.Data;

public class RequestView {
	
	
	public void show(ArrayList<Review> review) {
		
		
	}
	
	public int getNumber() {
		Scanner scan=new Scanner(System.in);
		System.out.print("삭제할 리뷰 선택 : ");
		return scan.nextInt();
	}


	public void showAllRequest(ArrayList<Request> requestList) {


		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|               리뷰 관리 - 리뷰 삭제 요청 조회               <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%6s%15s\t%10s\t\t%-15s%-15s%-20s", "[요청 번호]","[작성일]","[요청 업체]","[요청 사유]","[리뷰 번호]","[승인 여부]");
		System.out.println(header);
		

		for(Request r : requestList) {
			String tmp = "";
			tmp = String.format("%6s%18s%20s\t%15s%15s\t\t%-20s",
					r.getRequestNumber(),
					r.getDateWritten(),
					r.getLicenseNumber(),
					r.getReason(),
					r.getReviewNumber(),
					r.getPermission().equals("null")? "대기":r.getPermission());

			System.out.println(tmp);
			
		}
	}
	
	public void hasNoHistory() {
		System.out.println();
		System.out.println("요청 내역이 없습니다.");
		System.out.println();
		View.pause();
	}

	public void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 리뷰 내용 보기              ■");
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

	public String getRequestNumber() {
		System.out.println("확인할 요청 번호 입력하세요");
		System.out.print("선택(요청번호) : ");

		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		return tmp;
	}
	
	public void showAlreadPermittedMessage() {
		System.out.println();
		System.out.println("이미 승인된 요청입니다.");
		System.out.println();
		View.pause();
	}

}
