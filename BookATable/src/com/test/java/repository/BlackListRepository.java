package com.test.java.repository;

import java.util.ArrayList;

import com.test.java.model.BlackList;

public class BlackListRepository {

	public static boolean findOne(String lisenceNumber, String key) {
		
		for(BlackList b : Data.blackListList) {
			if(b.getLicenseNumber().equals(lisenceNumber) && b.getUserId().equals(key)) {
				return true;
			}
		}
		
		return false;
	}

	public static void addOne(String licenseNumber, String userId) {
		BlackList tmp = new BlackList(licenseNumber, userId);
		Data.blackListList.add(tmp);
	}
	
	
	public static ArrayList<BlackList> findAll(String lisenceNumber, String key) {
		
		return Data.blackListList;
	}
}
