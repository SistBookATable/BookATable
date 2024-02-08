package com.test.java.repository;

import java.util.ArrayList;

import com.test.java.model.Request;

public class ReqeustRepository {

	public static ArrayList<Request> findAll() {
		return Data.requestList;
	}

}
