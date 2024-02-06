package com.test.java.repository;

import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Request;

public class RequestRepository {

	
	public static ArrayList<Request> FindAllRequest() {
		return Data.requestList;
	}
	
	public static void addRequest(int reviewNumber, String licenseNumber, String reason, String requester) {
		Calendar cur = Calendar.getInstance();
		String today = String.format("%tF", cur);
		Request tmp = new Request(0, reviewNumber, licenseNumber, reason, requester, today, null);
		Data.requestList.add(tmp);
	}

}
