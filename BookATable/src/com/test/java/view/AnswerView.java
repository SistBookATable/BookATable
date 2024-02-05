package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Inquiry;

public class AnswerView {

	public void show(Inquiry inquiry) {
		
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|         문의사항 관리 - 문의 사항 조회 - 문의 내용 보기         <");
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
	}

	public void showSelectBox() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 답변 등록                  ■");
		System.out.println("■           2. 답변 삭제                  ■");
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

	public void hasAnswerMessage() {
		
		System.out.println();
		System.out.println("이미 등록된 답변이 있습니다.");
		System.out.println();
		
		View.pause();
		
	}

	public String getAnswer() {

		Scanner scan = new Scanner(System.in);
		String answer = "";
		
		System.out.println();
		System.out.println("등록할 답변을 입력하세요");
		System.out.println("입력이 완료되면 마지막에 \"wq\"를 입력하세요 ");
		
		while(scan.hasNext()) {
			String tmp = scan.nextLine();
			
			int len = tmp.length();
			if(len >= 2 && tmp.charAt(len-2)=='w' && tmp.charAt(len-1)=='q') {
				if(tmp.length()>2) {
					answer += tmp.substring(0, tmp.length()-2);
				}
				break;
			}
			answer += tmp + "\n";
		}
		
		System.out.println();
		return answer;
	}

	public void deleteSuccessMessage() {

		System.out.println();
		System.out.println("답변 삭제가 완료되었습니다.");
		System.out.println();
		
		View.pause();
		
	}

}
