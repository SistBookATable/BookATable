package com.test.java.repository;

import java.util.ArrayList;

import com.test.java.model.Inquiry;
/**
 * inquiry정보를 전체조회 하거나 회원ID로 조회하고, 새로운 inquiry 정보를 추가하는 클래스입니다.
 */
public class InquiryRepository {

	/**
	 * 주어진 회원ID와 일치하는 요청내역을 조회하는 메서드입니다.
	 * @param id
	 * @return 조건문이 참인 경우에 ArrayList<Inquiry>에 Inquiry 개체를 추가하여 반환합니다.
	 */
	public static ArrayList<Inquiry> findOneById(String id) {
		
		ArrayList<Inquiry> tmp = new ArrayList<>();
		for(Inquiry i : Data.inquiryList) {
			if(i.getUserId().equals(id)) {
				tmp.add(i);
			}
		}
		
		return tmp;
	}

	/**
	 * Inquiry에 새로운 개체를 추가하는 메서드입니다.
	 * 또한, Data의 inquiryList에 데이터를 추가합니다.
	 * @param i
	 * @param id
	 * @param title
	 * @param content
	 * @param level
	 * @param today
	 * @param string
	 * @param string2
	 */
	public static void add(int i, String id, String title, String content, int level, String today, String string,
			String string2) {
		Inquiry tmp = new Inquiry(i, id, title, content, level, today, string, string2);
		Data.inquiryList.add(tmp);
	}
	
	
	/**
	 * 모든 ArrayList<Inquiry> 조회하여 Data.inquiryList를 반환하는 메서드입니다.
	 * @return Data.inquiryList
	 */
	public static ArrayList<Inquiry> findAll() {
		return Data.inquiryList;
	}

}
