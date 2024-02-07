package com.test.java.controller;

import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Inquiry;
import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.UserInquiryView;

public class UserInquiryController {

	public void userInquiry() {

		UserInquiryView userInquiryView = new UserInquiryView();
		
		boolean loop = true;
		while(loop) {
			
			userInquiryView.showTitle(Member.level);
			userInquiryView.showSelectBox();
			int choice = userInquiryView.getSelectType();
			
			switch(choice) {
			case 1:
				//문의 제목 입력하기
				userInquiryView.showTitleInputBox();
				String title = userInquiryView.getTitle();
				
				//문의 내용 입력하기
				userInquiryView.showContentInputBox();
				String content = userInquiryView.getContent();
				
				//오늘 날짜 구하기
				Calendar cur = Calendar.getInstance();
				String today = String.format("%tF", cur);
				
				//문의 인스턴스 생성하기
				Inquiry inquiry = new Inquiry(++Inquiry.COUNT, Member.id, title, content, Member.level, today,
						"null", "null");
				
				//문의 리스트에 추가
				Data.inquiryList.add(inquiry);
				
				//문의 등록 완료 메시지
				userInquiryView.successMessage();
				
				break;
			case 2:
				//문의 내역 조회
				
				//내ID에 해당하는 문의 리스트 조회
				ArrayList<Inquiry> inquiryList = findById(Member.id);
				
				//문의 내역이 없을 때
				if(inquiryList.isEmpty()) {
					userInquiryView.hasNoHistoryMessage();
					continue;
				}
				
				//문의 번호, 답변여부, 작성일, 문의 제목이 들어있는 문의 리스트 출력
				userInquiryView.showTitleList(inquiryList,Member.level);
				
				while(true) {

					//조회할 문의 번호 선택
					int inquiryNumber = userInquiryView.getInquiryNumber();
					
					//문의 번호에 해당하는 Inquiry 조회
					Inquiry selected = findOne(inquiryNumber,inquiryList);
					
					//내가 문의한 문의 번호가 아닌 경우
					if(selected==null) {
						userInquiryView.incorrectNumberMessage();
						continue;
					}
					else {
						//문의 디테일 출력
						userInquiryView.showDetail(selected);
						break;
					}
				}
				
				
				break;
			case 3:
				loop = false;
				break;
			default:
				userInquiryView.incorrectNumberMessage();
			}
			
		}
		
	}

	private Inquiry findOne(int inquiryNumber, ArrayList<Inquiry> inquiryList) {
		for(Inquiry i : inquiryList) {
			if(i.getInquiryNumber()==inquiryNumber) {
				return i;
			}
		}
		
		return null;
	}

	private ArrayList<Inquiry> findById(String id) {
		
		ArrayList<Inquiry> tmp = new ArrayList<>();
		for(Inquiry i : Data.inquiryList) {
			if(i.getUserId().equals(id)) {
				tmp.add(i);
			}
		}
		
		return tmp;
	}

}
