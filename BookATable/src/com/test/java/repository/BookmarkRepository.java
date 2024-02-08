package com.test.java.repository;

import java.util.Iterator;

import com.test.java.model.Bookmark;
import com.test.java.model.PointUsage;

public class BookmarkRepository {

	public static int findAllCount(String lisenceNumber) {
		int tmp = 0;
		
		for(Bookmark b : Data.bookmarkList) {
			if(b.getLicenseNumber().equals(lisenceNumber)) {
				tmp++;
			}
		}
		return tmp;
	}
	
	
	public static void delete(Bookmark bookmark) {
		
		Iterator it = Data.bookmarkList.iterator();
		
		while(it.hasNext()) {
			Bookmark b = (Bookmark) it.next();

			if(b.getLicenseNumber() == bookmark.getLicenseNumber()) {
				it.remove();
			}	
		}		
	}
	
	public static Bookmark findDelectByLicense(String licenseNumber) {
		Bookmark tmp = null;
		for(Bookmark b :Data.bookmarkList) {
			if(b.getLicenseNumber().equals(licenseNumber)) {
				tmp = b;
			}
		}
		return tmp;
	}

}
