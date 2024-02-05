package com.test.java.repository;

import java.util.ArrayList;

import com.test.java.model.Request;

public class RequestRepository {

	public static ArrayList<Request> FindAllRequest() {
		return Data.requestList;
	}

}
