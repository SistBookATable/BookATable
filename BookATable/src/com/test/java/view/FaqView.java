package com.test.java.view;

import java.util.Scanner;

import com.test.java.controller.FaqController;
import com.test.java.controller.UserMyPageController;
import com.test.java.model.Faq;
/**
* FaqView 클래스는 FAQ 관련 기능을 담당하는 뷰 클래스입니다.
* 사용자에게 FAQ 목록을 보여주고, 선택한 FAQ에 대한 내용을 출력합니다.
* 또한 이전 화면으로 이동하거나 MyPage로 이동할 수 있는 기능을 제공합니다.
*/
public class FaqView {

	/**
	 * FAQ의 메인화면을 출력하는 메서드입니다.
	 */
	public static void showFaq() {
		System.out.println();
		System.out.println();
		System.out.println("‖¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯‖");
		System.out.println("		     FAQ		     ");
		System.out.println("‖‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‖");
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
	
	/**
	 * 회원에게 조회할 FAQ번호를 입력받는 메서드입니다.
	 * @return 회원이 입력한 FAQ번호
	 */
	public static int getSelectNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.print("선택(번호) : ");
		int num = scan.nextInt();
		return num;
	}
	

	/**
	 * 선택한 FAQ 번호에 해당하는 FAQ를 화면에 출력합니다.
	 * @param selectNum 선택한 FAQ 객체
	 */
	public static void showFaqBySelectNum(Faq selectNum) {
		
		// 선택한 FAQ 객체를 selectFaq 변수에 저장합니다.
		Faq selectFaq =selectNum;
		
		// 질문과 답변을 가져옵니다.
		String questionList = selectFaq.getQuestion();
		String answerList = selectFaq.getAnswer();
		
		// 질문과 답변을 배열로 분리합니다.
		String[] question = questionList.split("\\.");
		String[] answer = answerList.split("\\.");
		System.out.println();
		
		// FAQ 제목을 출력합니다.
		System.out.printf("%s\n",selectFaq.getTitle());
		System.out.println("========================================================");
		
		// 질문을 출력합니다.
		for(int i = 0 ; i < question.length; i++) {
			System.out.printf("%s\n",question[i]);
		}
		System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
		
		// 답변을 출력합니다.
		for(int i = 0 ; i < answer.length; i++) {
			System.out.printf("%s\n",answer[i]);
		}
		System.out.println("========================================================");
		System.out.println();
		System.out.println("1. MyPage");
		System.out.println("0. 이전 화면");
		
		// 반복문을 통해 사용자 입력을 받고 처리합니다.
		boolean loop = true;
		FaqController faq = new FaqController();
		UserMyPageController userMyPage = new UserMyPageController();
		
		while(true) {
			int num = getSelectNumber(); // 사용자에게 번호를 입력 받는 메서드
			
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
