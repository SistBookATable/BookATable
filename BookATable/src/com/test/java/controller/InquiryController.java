package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Inquiry;
import com.test.java.view.InquiryView;

public class InquiryController {
	
	private InquiryView inquiryView;
	private ArrayList<Inquiry> inquiryList;
	
	public InquiryController(InquiryView inquiryView,ArrayList<Inquiry> inquiryList) {
		this.inquiryList=inquiryList;
		this.inquiryView=inquiryView;
	}
	
	public void findById(String userId) {
		
		
	}
	
	public void findByNumber(String inquiryNumber) {
		
		
	}
	
	public void findByAll() {
		
		
	}
	
	public void addAnswer() {
		
	}
	
	public void removeAnswer() {
		
	}
	
	

}
