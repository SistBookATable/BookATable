package com.test.java.repository;

import java.util.ArrayList;

import com.test.java.model.Inquiry;

public class InquiryRepository {

	public static ArrayList<Inquiry> findOneById(String id) {
		
		ArrayList<Inquiry> tmp = new ArrayList<>();
		for(Inquiry i : Data.inquiryList) {
			if(i.getUserId().equals(id)) {
				tmp.add(i);
			}
		}
		
		return tmp;
	}

	public static void add(int i, String id, String title, String content, int level, String today, String string,
			String string2) {
		Inquiry tmp = new Inquiry(i, id, title, content, level, today, string, string2);
		Data.inquiryList.add(tmp);
	}

}
