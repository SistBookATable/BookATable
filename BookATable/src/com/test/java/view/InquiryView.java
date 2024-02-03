package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Inquiry;
import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;

public class InquiryView {
	
	public void show(Inquiry inquiry) {
		
	}
	
	
	public void show(ArrayList<Inquiry> inquiry) {
		
	}
	
	public ArrayList<String> getAnswer(){
		return null;
		
	}


	public void FindAllInquiry() {


		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|               문의사항 관리 - 문의 사항 조회                <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%6s%15s\t%10s\t\t%-15s%-15s%-20s", "[문의 번호]","[답변여부]","[작성일]","[문의자]","[회원타입]","[제목]");
		System.out.println(header);
		
		if(Data.inquiryList.isEmpty()) {
			System.out.println();
			System.out.println("문의 내역이 없습니다.");
			System.out.println();
			View.pause();
		}
		else {


			for(Inquiry i : Data.inquiryList) {
				String tmp = "";
				tmp = String.format("%6s%18s%20s\t%15s%15s\t\t%-20s",
						i.getInquiryNumber(),
						i.getAnswer().equals("null")? "답변 대기":"답변 완료",
						i.getDateWritten(),
						i.getUserId(),
						i.getType().equals("1")? "일반회원":"업체회원",
						i.getTitle());

				System.out.println(tmp);
				
			}
		}
	}


	public void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 문의 내용 보기              ■");
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


	public String getInquiryNumber() {
		System.out.println("확인할 문의 번호 입력하세요");
		System.out.print("선택(문의번호) : ");

		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		return tmp;
	}

}
