package com.test.java.view;

import java.util.Scanner;

import com.test.java.controller.FaqController;
import com.test.java.controller.UserMyPageController;
import com.test.java.model.Faq;

public class FaqView {

	public static void showFaq() {
		System.out.println();
		System.out.println();
//		System.out.println("‖‗▶=¦|⌈⌉⌊⌋—–-−¯");
		System.out.println("‖¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯‖");
		System.out.println("‖			    FAQ                         ‖");
		System.out.println("‖‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‖");
		System.out.println();
		System.out.println("========================================================");
		System.out.println();
		System.out.println("		▶1.[노쇼확정 기준시간]");
		System.out.println("		▶2.[노쇼횟수 누적에 따른 서비스 이용 정지]");
		System.out.println("		▶3.[예약취소 불가 상태와 포인트 환불 불가]");
		System.out.println("		▶4.[특정업체 이용제한]");
		System.out.println("		▶5.[포인트 출금계좌 변경]");
		System.out.println("		▶6.[충전 포인트 환불]");
		System.out.println("		▶0. 이전화면");
		System.out.println();
		System.out.println("========================================================");
		System.out.println();
		
	}
	
	public static int getSelectNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.print("선택(번호) : ");
		int num = scan.nextInt();
		return num;
	}
	

	public static void showFaqBySelectNum(Faq f) {
		
		Faq selectFaq =f;
		String questionList = selectFaq.getQuestion();
		String answerList = selectFaq.getAnswer();
		String[] question = questionList.split("\\.");
		String[] answer = answerList.split("\\.");
		System.out.println();
		System.out.printf("%s\n",selectFaq.getTitle());
		System.out.println("========================================================");
		for(int i = 0 ; i < question.length; i++) {
			System.out.printf("%s\n",question[i]);
		}
		System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
		for(int i = 0 ; i < answer.length; i++) {
			System.out.printf("%s\n",answer[i]);
		}
		System.out.println("========================================================");
		System.out.println();
		System.out.println("1. MyPage");
		System.out.println("0. 이전 화면");
		
		
		boolean loop = true;
		FaqController faq = new FaqController();
		UserMyPageController userMyPage = new UserMyPageController();
		
		while(true) {
			int num = getSelectNumber();
			
			switch(num) {
			//1. MyPage로 이동
			case 1:
				userMyPage.userMyPage();
				break;
			//0. FaqView 화면으로 이동
			case 0:
				FaqController.faqController();
				break;
			default:
				System.out.println("0,1만 입력 가능합니다.");
				break;
			}
			loop = false;
		}
		
	}
	
}
