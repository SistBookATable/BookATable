package com.test.java.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.test.java.model.Inquiry;
import com.test.java.repository.Data;
import com.test.java.repository.InquiryRepository;
import com.test.java.view.InquiryView;

/**
 * InquiryController는 문의내역 출력, 건별 문의내역 조회, 문의내용 답변작성에 관련한 개체를 호출하는 클래스입니다.
 */
public class InquiryController {

	/**
	 * 문의를 관리하는 메서드입니다.
	 */
	public void inquiryManagement() {

		InquiryView inquiryView = new InquiryView();

		boolean loop = true;
		while (loop) {

			ArrayList<Inquiry> inquiryList = InquiryRepository.findAll(); // 모든 문의 조회
			Collections.sort(inquiryList, (o1, o2) -> o1.getDateWritten().compareTo(o2.getDateWritten())); // 문의 작성일자로 정렬
																											
			inquiryView.FindAllInquiry(inquiryList);// 조회된 문의 목록 출력
			inquiryView.showSelectBox();// 사용자 선택옵션 입력 메서드 호출

			int choice = inquiryView.getSelectType();

			if (choice == 1) {
				// 문의 번호 입력 받기
				String inquiryNumber = inquiryView.getInquiryNumber();

				// 문의번호를 사용해서 문의내역 찾기
				Inquiry selected = find(inquiryNumber);

				// 문의내용 보고 답변하기
				AnswerController answerController = new AnswerController();
				answerController.answerManage(selected);

			} else if (choice == 0) {
				loop = false;
			} else {
				// 유효하지 않은 값 입력시 메시지 출력
				inquiryView.incorrectInputMessage();
			}
		}

	}

	/**
	 * 문의번호로 문의내역을 찾는 메서드입니다.
	 * 
	 * @param inquiryNumber 문의번호
	 * @return 해당 문의번호에 해당하는 문의 객체
	 */
	private Inquiry find(String inquiryNumber) {

		for (Inquiry i : Data.inquiryList) {
			if (i.getInquiryNumber() == Integer.parseInt(inquiryNumber)) {
				return i;
			}
		}
		return null;
	}

}
