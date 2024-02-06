package com.test.java.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Faq;
import com.test.java.model.Inquiry;
import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.FaqView;

public class FaqController {
	

	public void faqController() {
		System.out.println("FaqController");
		
		FaqView faqview = new FaqView();
		FaqView.showFaq();
		int choice = FaqView.getSelectNumber();
		System.out.println(choice);
		boolean loop = true;
		Faq selectedFaq = findByNum(choice);
		System.out.println(selectedFaq);
		while(loop) {
			switch(choice) {
			case 1:
				FaqView.showFaqBySelectNum(selectedFaq);
				break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 0:
				System.out.println("이전화면으로 이동합니다.");
				loop = false;
				break;
			default:
				System.out.println("1,2,3,4,5,6,0으로 입력해주세요.");
			}
			loop = false;
		}
	}
	private static Faq findByNum(int faqNumber) {
//		String 
		for(Faq f: Data.faqList) {
			System.out.println("list");
			System.out.println(f);
//			if(faqList.get(0)==faqNumber ) {
//				return f;
//			}
	
		}
		return null;
	}
	

}
