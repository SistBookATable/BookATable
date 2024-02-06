package com.test.java.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Faq;
import com.test.java.model.Inquiry;
import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.FaqView;

public class FaqController {
	

	public static void faqController() {
		System.out.println("FaqController");
		
		FaqView faqview = new FaqView();
		faqview.showFaq();
		FaqController.faqViewController();

		
	}
	
	private static void faqViewController() {
		UserMyPageController userMyPage = new UserMyPageController();
		

		boolean loop = true;
		while(loop) {
			
			int choice = FaqView.getSelectNumber();
			Faq selectedFaq = findByNum(choice);
			
			switch(choice) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				FaqView.showFaqBySelectNum(selectedFaq);
				
				loop = false;
				break;
			case 0:
				System.out.println("이전화면으로 이동합니다.");
				userMyPage.userMyPage();
				break;
			default:
				System.out.println("1,2,3,4,5,6,0으로 입력해주세요.");
				faqViewController();
				break;
			}
			loop = false;
		}
	}
	
	private static Faq findByNum(int faqNumber) {
		for(Faq f: Data.faqList) {
			if(f.getFaqNumber()==faqNumber ) {
				return f;
			}
		}
		return null;
	}
	

}
