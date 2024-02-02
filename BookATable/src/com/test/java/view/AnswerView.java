package com.test.java.view;

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
		System.out.println(inquiry.getAnswer());
	}

	public void showSelectBox() {
		
		
	}

}
