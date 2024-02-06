package com.test.java.repository;

import com.test.java.model.Store;

public class StoreRepository {
	public static Store findOneByLicenseNumber(String licenseNumber) {
		for(Store s : Data.storeList) {
			if(s.getLicenseNumber().equals(licenseNumber)) {
				return s;
			}
		}
		return null;
	}

}
