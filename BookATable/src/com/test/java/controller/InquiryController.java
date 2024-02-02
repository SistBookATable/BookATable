package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Inquiry;
import com.test.java.view.InquiryView;

public class InquiryController {

	public void inquiryManagement() {
		
		InquiryView inquiryView = new InquiryView();
		inquiryView.FindAllInquiry();
		
	}
	
	

}
