package com.test.java.repository;

import java.util.Iterator;

import com.test.java.model.Bookmark;
import com.test.java.model.PointUsage;

/**
 * bookmark 정보를 조회하고 삭제하는 클래스입니다.
 */
public class BookmarkRepository {

	/**
	 * 주어진 사업자등록번호에 해당하는 북마크 항목의 개수를 조회하는 메서드입니다.
	 * 
	 * @param lisenceNumber 사업자등록번호
	 * @return 주어진 사업자등록번호에 해당하는 북마크 항목의 개수를 반환합니다.
	 */
	public static int findAllCount(String lisenceNumber) {
		int tmp = 0;

		for (Bookmark b : Data.bookmarkList) {
			if (b.getLicenseNumber().equals(lisenceNumber)) {
				tmp++;
			}
		}
		return tmp;
	}

	/**
	 * 즐겨찾기된 음식점의 사업자등록번호와 북마크 데이터의 사업자등록번호가 일치하면, 북마크 항목을 삭제하는 메서드입니다.
	 * @param bookmark 삭제할 북마크 항목
	 */
	public static void delete(Bookmark bookmark) {

		Iterator it = Data.bookmarkList.iterator();

		while (it.hasNext()) {
			Bookmark b = (Bookmark) it.next();

			if (b.getLicenseNumber() == bookmark.getLicenseNumber()) {
				it.remove();
			}
		}
	}

	/**
	 * 사업자등록번호에 해당하는 북마크 항목을 조회하는 메서드입니다.
	 * 
	 * @param licenseNumber 사업자등록번호
	 * @return 주어진 사업자등록번호에 해당하는 북마크 항목을 반환합니다. 없을 경우 null을 반환합니다.
	 */
	public static Bookmark findDelectByLicense(String licenseNumber) {
		Bookmark tmp = null;
		for (Bookmark b : Data.bookmarkList) {
			if (b.getLicenseNumber().equals(licenseNumber)) {
				tmp = b;
			}
		}
		return tmp;
	}

}
