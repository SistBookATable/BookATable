package com.test.java.controller;

import com.test.java.view.BusinessUserInquiryView;

public class BusinessUserInquiryController {
	
	public void showChoice() {
		
		
		BusinessUserInquiryView businessUserInquiryView=new BusinessUserInquiryView();
		businessUserInquiryView.showChoice();
		int choice=BusinessUserInquiryView.get();
		
		switch(choice) {
		
		case 1:
			UserInquiryController userInquiryController = new UserInquiryController();
			userInquiryController.userInquiry();
			break;
			
		case 2:
			InquiryController inquiryController = new InquiryController();
			inquiryController.inquiryManagement();
			
		case 0:
			BusinessUserMyPageController back =new BusinessUserMyPageController();
			back.businessUserMyPage();
		}
	}

}
