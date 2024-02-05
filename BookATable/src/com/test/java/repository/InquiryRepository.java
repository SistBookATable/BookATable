package com.test.java.repository;

import com.test.java.model.Inquiry;

public class InquiryRepository {

	public static Inquiry findOneByInquiryNumber(String inquiryNumber) {
		for(Inquiry i : Data.inquiryList) {
			if(i.getInquiryNumber() == Integer.parseInt(inquiryNumber)) {
				return i;
			}
		}
		return null;
	}
	
}
