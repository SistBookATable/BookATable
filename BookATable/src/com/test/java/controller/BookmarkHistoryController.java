package com.test.java.controller;

import java.util.Scanner;

import com.test.java.model.Bookmark;
import com.test.java.model.Member;
import com.test.java.model.Menu;
import com.test.java.model.Store;
import com.test.java.model.Table;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.StoreRepository;
import com.test.java.view.BookmarkHistoryView;
import com.test.java.view.MoveStorePageView;

public class BookmarkHistoryController {

	
	
	public void bookmarkHistory() {

		
		String UserId = Member.id;
		String licenseNumber = findBookmarkLicenseById(UserId);
		
		Store selected = StoreRepository.findOneByName(licenseNumber); 
		
		// 상호명
		String storeName = selected.getStoreName();
		// 전화번호
		String telPhone = selected.getStoreTelNumber();
		// 메뉴
		String menu = findMenu(licenseNumber);
		
		BookmarkHistoryView.showBookmarkHistory(findNameById(Member.id)
												, storeName
												, telPhone
												, menu);
		
		boolean loop = true;
		while(loop) {
			BookmarkHistoryView.showSelectBox();
			int choice = BookmarkHistoryView.get();
			
			switch(choice) {
			// 상세페이지 보기
			case 1:
//				MoveStorePageController moveStorePageController = new MoveStorePageController();
//				moveStorePageController.moveStorePage();
				moveStorePage();
				break;
			// 즐겨찾기 삭제 
			case 2:
				DeleteBookmarkController deleteBookmarkController = new DeleteBookmarkController();
				deleteBookmarkController.deleteBookmark();
				break;
			case 0:
				loop = false;
				break;
			}
		}
		
		
	}
	

	// 아이디로 사업자등록번호 찾기
	private String findBookmarkLicenseById(String UserId) {
	for(Bookmark bookmark : Data.bookmarkList) {
		if (bookmark.getUserId().equals(UserId)) {
					return bookmark.getLicenseNumber();
			}
		}
	return null;
	}
	
//	private String findMenuNameById(String id) {
//		for(Bookmark b : Data.bookmarkList) {
//			if (b.getUserId().equals(id)) {
//				for(Menu m : Data.menuList) {
//					if (m.getLicenseNumber().equals(b.getLicenseNumber())) {
//						return m.getMenuName();
//					}
//				}
//			}
//		}
//		return null;
//	}
//
//
//
//	private String findStoreTelNumberById(String id) {
//		for(Bookmark b : Data.bookmarkList) {
//			if (b.getUserId().equals(id)) {
//				for(Store s : Data.storeList) {
//					if (s.getLicenseNumber().equals(b.getLicenseNumber())) {
//						return s.getStoreTelNumber();
//					}
//				}
//			}
//		}
//		return null;
//	}
//
//	private String findStoreNameById(String id) {
//		for(Bookmark b : Data.bookmarkList) {
//			if (b.getUserId().equals(id)) {
//				for(Store s : Data.storeList) {
//					if (s.getLicenseNumber().equals(b.getLicenseNumber())) {
//						return s.getStoreName();
//					}
//				}
//			}
//		}
//		return null;
//	}

	private String findNameById(String id) {
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				return u.getName();	
				}
			}
		return null;
		}
	
	
	
	
	// 상세페이지 이동
	public void moveStorePage() {
		
		MoveStorePageView moveStorePageView = new MoveStorePageView();
		
		String storeName = moveStorePageView.getStoreName();
		
		Store selected = StoreRepository.findOneByName(storeName);
		
		// 상호명으로 음식점 정보 조회(전화번호)
		String telPhone = selected.getStoreTelNumber();
		// 주소 조회
		String address = selected.getAddress();
		// 사업자번호
		String licenseNumber = selected.getLicenseNumber();
		// 테이블 조회 (테이블)
		int table = findTable(licenseNumber);
		// 평점 조회
		double score = selected.getScore();
		// 음식분류 조회
		String menuCategory = selected.getMenuCategory();
		// 메뉴 출력
		String menu = findMenu(licenseNumber);
		
		
		if (storeName != null) {
			moveStorePageView.showStorePage(storeName, telPhone, address, menuCategory, menu, table, score);
		} else {
			System.out.println("해당 음식점이 존재하지 않습니다.");
		}
		
		System.out.println("<<엔터를 입력하면, 이전 화면으로 이동합니다.>>");
		
		
		// 엔터 입력 대기
		waitForEnter();
		
		// 이전 화면 이동
		BookmarkHistoryController bookmarkHistoryController = new BookmarkHistoryController();
		bookmarkHistoryController.bookmarkHistory();
		
	}

	private String findMenu(String licenseNumber) {
		for (Menu menu : Data.menuList) {
			if (menu.getLicenseNumber().equals(licenseNumber)) {
				return menu.getMenuName();
			}
		}
		return null;
	}


	private int findTable(String licenseNumber) {
		for (Table table : Data.tableList) {
			if (table.getLicenseNumber().equals(licenseNumber)) {
				return table.getTableCapacity(); 
			}
		}
		return 0;
	}


	private void waitForEnter() {
		Scanner scan = new Scanner(System.in);
		scan.nextLine(); // 사용자가 엔터를 입력할 때까지 대기
		
	}	
	
	
	
	

}
