package com.test.java.repository;

import com.test.java.model.Store;

public class StoreRepository {
	public static Store findOneByLicenseNumber(String lisenceNumber) {
		for(Store s : Data.storeList) {
			if(s.getLicenseNumber().equals(lisenceNumber)) {
				return s;
			}
		}
		return null;
	}

	public static Store findOneByName(String storeName) {
		for(Store s : Data.storeList) {
			if(s.getStoreName().equals(storeName)) {
				return s;
			}
		}
		return null;
	}

	public static String findNameOneByLicenseNumber(String lisenceNumber) {
		for(Store s : Data.storeList) {
			if(s.getLicenseNumber().equals(lisenceNumber)) {
				return s.getStoreName();
			}
		}
		return null;
	}

}
