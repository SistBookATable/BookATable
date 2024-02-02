package com.test.java.view;

import java.util.ArrayList;

import com.test.java.model.Inquiry;
import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;

public class InquiryView {
	
	public void show(Inquiry inquiry) {
		
		
	}
	
	
	public void show(ArrayList<Inquiry> inquiry) {
		
	}
	
	public ArrayList<String> getAnswer(){
		return null;
		
	}


	public void FindAllInquiry() {


		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|               문의사항 관리 - 문의 사항 조회                <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%15s%15s%15s%20s%15s", "[작성일]","[문의자]","[회원타입]","[제목]","[답변여부]");
		System.out.println(header);

		for(Inquiry i : Data.inquiryList) {

			String tmp = "";
			tmp = String.format("%15s%15s%15s%20s%15s",
					i.getDateWritten(),
					i.getUserId(),
					i.getType(),
					i.getAnswer(),
					i.getAnswer().equals("null")? "답변 대기":"답변 완료");

			System.out.println(tmp);
			
		}
	}
	
	

}
