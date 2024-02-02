package com.test.java.controller;

import com.test.java.model.Inquiry;
import com.test.java.view.AnswerView;

public class AnswerController {
	

	public void answerManage(Inquiry selected) {
		
		AnswerView answerView = new AnswerView();
		answerView.show(selected);
		answerView.showSelectBox();
		
	}
	
}
