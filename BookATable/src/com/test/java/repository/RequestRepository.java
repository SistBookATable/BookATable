package com.test.java.repository;

import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Request;

public class RequestRepository {

	/**
	 * 모든 리뷰 삭제 Request 데이터 조회하고 ArrayList로 반환하는 메서드입니다.
	 * 
	 * @return
	 */
	public static ArrayList<Request> findAll() {
		return Data.requestList;
	}

	/**
	 * 리뷰 삭제 Request를 추가하는 메서드입니다.
	 * 
	 * @param reviewNumber
	 * @param licenseNumber
	 * @param reason
	 * @param requester
	 */
	public static void addRequest(int reviewNumber, String licenseNumber, String reason, String requester) {
		Calendar cur = Calendar.getInstance();
		String today = String.format("%tF", cur);
		Request tmp = new Request(0, reviewNumber, licenseNumber, reason, requester, today, "null");
		Data.requestList.add(tmp);
	}

	/**
	 * 주어진 reviewNumber로 Request 개체를 조회하고 반환하는 메서드입니다.
	 * 
	 * @param reviewNumber
	 * @return (r.getReviewNumber()==reviewNumber &&
	 *         r.getPermission().equals("대기"))이면 Request r을 반환하고, 아니면 null을 반환합니다.
	 */
	public static Request findOneByReviewNumber(int reviewNumber) {

		for (Request r : Data.requestList) {
			if (r.getReviewNumber() == reviewNumber && r.getPermission().equals("대기")) {
				return r;
			}
		}
		return null;

	}

}
