package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Inquiry;
import com.test.java.repository.Data;

public class UserInquiryView {

	public void showTitle(int level) {
		String member = level==1 ? "일반 회원":"업체 회원";
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("|                    %s - 문의사항                   <\n",member);
		System.out.println("└───────────────────────────────────────────────────────┘");
		
	}

	public void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■            1. 문의 하기          \t■");
		System.out.println("■            2. 문의 내역 조회      \t■");
		System.out.println("■            0. 이전 화면	         \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
		
	}
	
	public void showAddInquiryTitle() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|            업체 회원 - 문의사항 - 문의 사항 등록              <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		
	}


	public int getSelectType() {
		return View.getSelectType();
	}

	public void showTitleInputBox() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■        문의 제목을 입력하세요   \t■");
		System.out.println("       (한 줄로만 입력 가능합니다.)");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("문의 제목 : ");
		
	}

	public String getTitle() {
		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		return tmp;
	}

	public void showContentInputBox() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■        등록할 문의 내용을 입력하세요 \t■");
		System.out.println("           여러줄로 입력이 가능합니다.  ");
		System.out.println("     입력이 완료되면 마지막에 \"wq\"를 입력하세요. ");
		System.out.println();
		System.out.println("==========================================================================================");
		
	}
	
	public void showDetail(Inquiry inquiry) {
		
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|         문의사항 - 문의 사항 조회 - 문의 내용 보기         <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String basic = String.format("작성일 : %s\n문의자 : %s\n제목 : %s",
				inquiry.getDateWritten(),
				inquiry.getUserId(),
				inquiry.getTitle());
		
		System.out.println(basic);
		System.out.println("───────────────────────────────────────────────────────");
		System.out.println("                        문의 내용");
		System.out.println("───────────────────────────────────────────────────────");
		System.out.println(inquiry.getContent());

		System.out.println("───────────────────────────────────────────────────────");
		System.out.println("                          답변");
		System.out.println("───────────────────────────────────────────────────────");
		System.out.println(inquiry.getAnswer().equals("null")? "아직 답변이 등록되지 않았습니다.":inquiry.getAnswer());
		
		View.pause();
	}

	public String getContent() {

		Scanner scan = new Scanner(System.in);
		String content = "";
		
		while(scan.hasNext()) {
			String tmp = scan.nextLine();
			
			int len = tmp.length();
			if(len >= 2 && tmp.charAt(len-2)=='w' && tmp.charAt(len-1)=='q') {
				if(tmp.length()>2) {
					content += tmp.substring(0, tmp.length()-2);
				}
				break;
			}
			content += tmp +"\n";
		}
		
		System.out.println();
		return content;
	}

	public void successMessage() {
		System.out.println();
		System.out.println("문의 등록이 완료되었습니다.");
		System.out.println();
		
		View.pause();
		
	}

	public void hasNoHistoryMessage() {
		System.out.println();
		System.out.println("등록된 문의 내역이 없습니다.");
		System.out.println();
		
		View.pause();
	}

	public void showTitleList(ArrayList<Inquiry> inquiryList, int level) {

		String member = level==1 ? "일반 회원":"업체 회원";
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("|             %s - 문의사항 - 문의 내역 조회             <\n",member);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%6s%15s\t%10s\t%-20s", "[문의 번호]","[답변여부]","[작성일]","[제목]");
		System.out.println(header);

		for(Inquiry i : inquiryList) {
			String tmp = "";
			tmp = String.format("%6s%18s%20s\t%-20s",
					i.getInquiryNumber(),
					i.getAnswer().equals("null")? "답변 대기":"답변 완료",
					i.getDateWritten(),
					i.getTitle());

			System.out.println(tmp);
			
		}
	}

	public int getInquiryNumber() {
		System.out.println("확인할 문의 번호 입력하세요");
		System.out.print("선택(문의번호) : ");

		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		scan.nextLine();
		return tmp;
	}

	public void incorrectNumberMessage() {


		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■            잘못된 입력입니다. \t\t■");
		System.out.println("     문의 내역에 존재하는 문의 번호를 입력해주세요.  ");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
	}

	
}
