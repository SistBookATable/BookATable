package com.test.java.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.test.java.model.Bookmark;
import com.test.java.model.Member;
import com.test.java.model.PointUsage;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.BookmarkRepository;
import com.test.java.repository.Data;
import com.test.java.repository.PointRepository;
import com.test.java.view.DeleteBookmarkView;

/**
 * 즐겨찾기를 삭제하는 기능을 담당하는 Controller 클래스입니다
 */
public class DeleteBookmarkController {

	/**
	 * 즐겨찾기를 삭제하는 메서드입니다
	 */
	public void deleteBookmark() {

		
        DeleteBookmarkView deleteBookmarkView = new DeleteBookmarkView();
        String inputStoreName = deleteBookmarkView.getStoreName();
        
        // 본인 즐겨찾기 조회 리스트 확인
        
        ArrayList<Bookmark> bookmarkList = findAllBook(Member.id);

        // 상호명에 해당하는 즐겨찾기가 있는지 확인
        boolean hasBookmarkForInputStoreName = false;

        // 즐겨찾기 조회 리스트에 있는지 확인
        Iterator<Bookmark> iterator = bookmarkList.iterator();
        while (iterator.hasNext()) {
            Bookmark bookmark = iterator.next();
            String licenseNumber = bookmark.getLicenseNumber();
            String storeName = findStoreNameByLicense(licenseNumber);

            // 상호명이 입력한 상호명과 일치하는지 확인
            if (storeName != null && storeName.equals(inputStoreName)) {
                hasBookmarkForInputStoreName = true;
                
                iterator.remove(); // 즐겨찾기 제거
                BookmarkRepository.delete(bookmark);
            }
        }

        if (hasBookmarkForInputStoreName) {
            deleteBookmarkView.deleteSuccess();
        } else {
            deleteBookmarkView.deleteFail();
        }
    }
    
    private ArrayList<Bookmark> findAllBook(String id) {
        ArrayList<Bookmark> tmp = new ArrayList<>();
        for (Bookmark m : Data.bookmarkList) {
            if (m.getUserId().equals(id)) {
                tmp.add(m);
            }
        }
        return tmp;
    }

    // 사업자 등록 번호로 상호명 찾기
    private String findStoreNameByLicense(String licenseNumber) {
        for (Store s : Data.storeList) {
            if (s.getLicenseNumber().equals(licenseNumber)) {
                return s.getStoreName();
            }
        }
        return null;
    }
}
