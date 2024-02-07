//package com.test.java.controller;
//
//import java.util.Scanner;
//
//import com.test.java.model.Bookmark;
//import com.test.java.model.Member;
//import com.test.java.model.Menu;
//import com.test.java.model.Store;
//import com.test.java.model.Table;
//import com.test.java.repository.Data;
//import com.test.java.repository.MemberRepository;
//import com.test.java.repository.StoreRepository;
//import com.test.java.view.BookmarkHistoryView;
//import com.test.java.view.MoveStorePageView;
//
//public class BookmarkHistoryController {
//
//	
//	public void bookmarkHistory() {
//
//		
//		
//		String id = Member.id;		
////		String licenseNumber = findBookmarkLicenseById(userId);
////		
////		Store selected = StoreRepository.findOneByName(licenseNumber); 
////		
////		// 상호명
////		String storeName = selected.getStoreName();
////		// 전화번호
////		String telPhone = selected.getStoreTelNumber();
////		// 메뉴
////		String menu = findMenu(licenseNumber);
//		
//		BookmarkHistoryView.showBookmarkHistory(findNameById(Member.id)
//												, findStoreNameById(Member.id)
//												, findStoreTelNumberById(Member.id)
//												, findMenuNameById(Member.id));
//		
//		boolean loop = true;
//		while(loop) {
//			BookmarkHistoryView.showSelectBox();
//			int choice = BookmarkHistoryView.get();
//			
//			switch(choice) {
//			// 상세페이지 보기
//			case 1:
//				MoveStorePageController moveStorePageController = new MoveStorePageController();
//				moveStorePageController.moveStorePage();
//				break;
//			// 즐겨찾기 삭제 
//			case 2:
//				DeleteBookmarkController deleteBookmarkController = new DeleteBookmarkController();
//				deleteBookmarkController.deleteBookmark();
//				break;
//			case 0:
//				loop = false;
//				break;
//			}
//		}
//		
//		
//	}
//	
//
//	// 아이디로 사업자등록번호 찾기
//	private String findBookmarkLicenseById(String id) {
//	for(Bookmark bookmark : Data.bookmarkList) {
//		if (bookmark.getUserId().equals(id)) {
//					return bookmark.getLicenseNumber();
//					
//			}
//		}
//	return null;
//	}
//
//
//	
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
//
//	private String findNameById(String id) {
//		for(Member u : Data.memberList) {
//			if(u.getId().equals(id)) {
//				return u.getName();	
//				}
//			}
//		return null;
//		}
//	
//	
//	private String findMenu(String licenseNumber) {
//		for (Menu menu : Data.menuList) {
//			if (menu.getLicenseNumber().equals(licenseNumber)) {
//				return menu.getMenuName();
//			}
//		}
//		return null;
//	}
//	
//	
//	
//	
//	
//
//}
