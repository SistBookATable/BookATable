package com.test.java.repository;

import java.util.ArrayList;

import com.test.java.model.Inquiry;

public class InquiryRepository {

	public static ArrayList<Inquiry> findAll() {
		return Data.inquiryList;
	}

}
