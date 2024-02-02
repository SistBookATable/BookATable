package com.test.java.controller;

import com.test.java.model.Inquiry;
import com.test.java.view.AnswerView;

public class AnswerController {
	
	
	public void answerManage(Inquiry selected) {

		AnswerView answerView = new AnswerView();
		
		boolean loop = true;
		while(loop) {

			answerView.show(selected);
			answerView.showSelectBox();
			int choice = answerView.getSelectType();
			
			switch (choice) {
			case 1:
				if(!selected.getAnswer().equals("null")) {
					answerView.hasAnswerMessage();
				}else {
					String answer = answerView.getAnswer();
					selected.setAnswer(answer);
				}
				break;
			case 2:
				selected.setAnswer("null");
				answerView.deleteSuccessMessage();
				break;
			case 0:
				loop = false;
				break;
			default:
				break;
			}
			
		}
		
		
	}
	
}
