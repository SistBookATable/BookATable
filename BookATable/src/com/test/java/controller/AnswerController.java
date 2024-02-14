package com.test.java.controller;

import com.test.java.model.Inquiry;
import com.test.java.model.Member;
import com.test.java.view.AnswerView;

/**
 * 문의사항에 대한 답변을 관리하는 컨트롤러 클래스입니다.
 */
public class AnswerController {
	
	/**
     * 선택된 문의사항에 대한 답변을 관리합니다.
     *
     * @param selected 답변을 관리할 문의사항 객체
     */
	public void answerManage(Inquiry selected) {

		AnswerView answerView = new AnswerView();
		
		boolean loop = true;
		while(loop) {

			answerView.show(selected);
			answerView.showSelectBox();
			int choice = answerView.getSelectType();
			
			switch (choice) {
			case 1:
				//답변 등록
				if(!selected.getAnswer().equals("null")) {
					answerView.hasAnswerMessage();
				}else {
					String answer = answerView.getAnswer();
					selected.setAdminId(Member.id);
					selected.setAnswer(answer);
				}
				break;
			case 2:
				//답변 삭제
				selected.setAnswer("null");
				selected.setAdminId("null");
				answerView.deleteSuccessMessage();
				break;
			case 0:
				//뒤로 가기
				loop = false;
				break;
			default:
				break;
			}
			
		}
		
		
	}
	
}
