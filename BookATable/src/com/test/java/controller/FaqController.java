package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Faq;
import com.test.java.view.FaqView;

public class FaqController {
	
	private FaqView faqView;
	private ArrayList<Faq> faqList;
	
	public FaqController(FaqView faqView, ArrayList<Faq>faqList) {
		this.faqList=faqList;
		this.faqView=faqView;
	}
	
	public void findByNumber(int faqNumber) {
		
		
	}
	

}
