package com.test.java.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.test.java.model.Inquiry;
import com.test.java.repository.Data;
import com.test.java.repository.InquiryRepository;
import com.test.java.view.InquiryView;

public class InquiryController {

	public void inquiryManagement() {

		InquiryView inquiryView = new InquiryView();
		
		boolean loop = true;
		while(loop) {

			ArrayList<Inquiry> inquiryList = InquiryRepository.findAll();
			Collections.sort(inquiryList, (o1, o2) -> o1.getDateWritten().compareTo(o2.getDateWritten()));
			inquiryView.FindAllInquiry(inquiryList);
			inquiryView.showSelectBox();
			int choice = inquiryView.getSelectType();
			
			if(choice == 1) {
				//문의 번호 입력 받기
				String inquiryNumber = inquiryView.getInquiryNumber();
				
				//문의번호를 사용해서 문의내역 찾기
				Inquiry selected = find(inquiryNumber);
				
				//문의내용 보고 답변하기
				AnswerController answerController = new AnswerController();
				answerController.answerManage(selected);
				
			}
			else if(choice == 0) {
				loop = false;
			}else {
				inquiryView.incorrectInputMessage();
			}
			
		}
		
		
		
	}

	private Inquiry find(String inquiryNumber) {
		
		for(Inquiry i : Data.inquiryList) {
			if(i.getInquiryNumber() == Integer.parseInt(inquiryNumber)) {
				return i;
			}
		}
		return null;
	}
	
	

}
