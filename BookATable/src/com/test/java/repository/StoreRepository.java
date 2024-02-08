package com.test.java.repository;

import java.util.Calendar;
import java.util.Iterator;

import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.view.SignOutUserManagementView;

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
	

	public static void add(String licenseNumber, String storeName, String storeTelNumber, String address,
			String menuCategory) {
		Store tmp = new Store(licenseNumber, storeName, storeTelNumber, address, menuCategory);
		Data.storeList.add(tmp);
		
	}

	public static void delete(String lisenceNumber) {
		Iterator it = Data.storeList.iterator();
		
		while(it.hasNext()) {
			Store s = (Store)it.next();

			if(s.getLicenseNumber().equals(lisenceNumber)) {
				it.remove();
			}	
		}
		
	}
	
}
