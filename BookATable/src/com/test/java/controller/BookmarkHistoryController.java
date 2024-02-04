package com.test.java.controller;

import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.BookmarkHistoryView;

public class BookmarkHistoryController {
	
	public void bookmarkHistory() {
		
		
		findNameById(Member.id);
		String name = findNameById(Member.id);
		
		// 사용자의 즐겨찾기 목록에서 음식점의 사업자등록번호 가져오기
		String userId = Member.id; //사용자의 아이디
		String licenseNumber = findBookmarkById(userId);
		
		// 음식점의 사업자등록번호로 음식점 정보 가져오기
		String storeName = findStoreNameBylicenseNumber(licenseNumber);
		String storeTelNumber = findStoreTelNumberBylicenseNumber(licenseNumber);
		String menuName = findMenuNameBylicenseNumber(licenseNumber);
		
		BookmarkHistoryView bookmarkHistoryView = new BookmarkHistoryView();
		bookmarkHistoryView.showBookmarkHistory(name, storeName, storeTelNumber, menuName);
		
		int choice = bookmarkHistoryView.get();
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while(loop) {
			switch(choice) {
			// 상세페이지 이동
			case 1: 
				break;
			// 즐겨찾기 삭제
			case 2:
				break;
			case 0:
				break;
			}
		}
		
		
		
		
		
	}
	
	private String findMenuNameBylicenseNumber(String licenseNumber) {
		for (Store s : Data.storeList) {
			if (s.getLicenseNumber().equals(licenseNumber)) {
				return s.getmenuName();
			}
		}
		return null;
	}

	// 전화번호
	private String findStoreTelNumberBylicenseNumber(String licenseNumber) {
		for (Store s : Data.storeList) {
			if (s.getLicenseNumber().equals(licenseNumber)) {
				return s.getStoreTelNumber();
			}
		}
		return null;
	}

	// 상호명 
	private String findStoreNameBylicenseNumber(String licenseNumber) {
		for (Store s : Data.storeList) {
			if (s.getLicenseNumber().equals(licenseNumber)) {
				return s.getStoreName();
			}	
		}
		return null;
	}

	// 즐겨찾기 목록에서 음식점의 사업자등록번호 가져오기 
	private String findBookmarkById(String userId) {
		for (String bookmark : Data.BOOKMARK) {
			String[] splitBookmark = bookmark.split(",");
			if (splitBookmark[1].equals(userId)) {
				return splitBookmark[0];
			}
		}
		return null;
	}

	// 이름
	private String findNameById(String id) {
		String name = "";
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				return u.getName();	
				}
			}
		return null;
		}	
		


}
