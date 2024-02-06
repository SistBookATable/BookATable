package com.test.java.repository;

import com.test.java.model.Bookmark;

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

}
