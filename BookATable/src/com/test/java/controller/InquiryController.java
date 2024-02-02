package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Inquiry;
import com.test.java.view.InquiryView;
import com.test.java.view.SignInUserManagementView;

public class InquiryController {

	public void inquiryManagement() {

		InquiryView inquiryView = new InquiryView();
		
		boolean loop = true;
		while(loop) {

			inquiryView.FindAllInquiry();
			inquiryView.showSelectBox();
			int choice = inquiryView.getSelectType();
			
			if(choice == 1) {
				//아이디 입력 받기
				String id = inquiryView.getId();
				
				//아이디를 사용해서 문의 
				
				
			}
			else if(choice == 0) {
				loop = false;
			}
			
		}
		
		
		
	}
	
	

}
