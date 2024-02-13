package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Inquiry;
import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;

/**
 * InquiryView 클래스는 1:1문의사항을 통해 요청된 내역의 정보를 출력하는 클래스입니다.
 */
public class InquiryView {
	
	/**
	 * 단일 문의 정보를 출력하는 메서드입니다.
	 * @param Inquiry inquiry
	 */
	public void show(Inquiry inquiry) {
		
	}
	
	/**
	 * 여러 개의 문의 정보를 출력하는 메서드입니다.
	 * @param ArrayList<Inquiry> inquiry
	 */
	public void show(ArrayList<Inquiry> inquiry) {
		
	}
	
	/**
	 * 문의에 대한 답변을 가져오는 메서드입니다.
	 * @return null
	 */
	public ArrayList<String> getAnswer(){
		return null;
		
	}


	/**
	 * 모든 문의 사항을 조회하고, 헤더의 형식으로 출력하는 메서드입니다.
	 * 문의내역의 유무와 답변 작성 유무, 회원타입 따라 다른 메세지가 출력됩니다.
	 * @param inquiryList
	 */
	public void FindAllInquiry(ArrayList<Inquiry> inquiryList) {


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


			for(Inquiry i : inquiryList) {
				String tmp = "";
				tmp = String.format("%6s%18s%20s\t%15s%15s\t\t%-20s",
						i.getInquiryNumber(),
						i.getAnswer().equals("null")? "답변 대기":"답변 완료",
						i.getDateWritten(),
						i.getUserId(),
						i.getType()==1? "일반회원":"업체회원",
						i.getTitle());

				System.out.println(tmp);
				
			}
		}
	}

	/**
     * 선택 옵션을 출력하는 메서드입니다.
     */
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
	
	/**
     * 사용자가 선택한 번호를 반환하는 메서드입니다.
     * @return 선택 번호
     */
	public int getSelectType() {
		return View.getSelectType();
	}

	/**
     * 사용자가 선택한 문의번호를 입력받는 메서드입니다.
     * @return 문의 번호
     */
	public String getInquiryNumber() {
		System.out.println("확인할 문의 번호 입력하세요");
		System.out.print("선택(문의번호) : ");

		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		return tmp;
	}


	/**
	 * 유효하지 않은 값을 입력한 경우 출력되는 메세지입니다.
	 */
	public void incorrectInputMessage() {


		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("      (1, 0) 중에 하나를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
	}

}
