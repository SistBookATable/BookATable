//package com.test.java.controller;
//
//import java.util.Iterator;
//import java.util.Scanner;
//
//import com.test.java.model.Bookmark;
//import com.test.java.model.Member;
//import com.test.java.model.Review;
//import com.test.java.model.Store;
//import com.test.java.repository.Data;
//import com.test.java.view.DeleteBookmarkView;
//
//public class DeleteBookmarkController {
//
//	public void deleteBookmark() {
//
//		DeleteBookmarkView deleteBookmarkView = new DeleteBookmarkView();
//		String inputStoreName = DeleteBookmarkView.getStoreName();
//
//		String licenseNumber = findLicenseNumberByStoreName(inputStoreName);
//
//		Iterator<Bookmark> it = Data.bookmarkList.iterator();
//		while (it.hasNext()) {
//			Bookmark bookmark = it.next();
//			if (bookmark.getUserId().equals(Member.id) && bookmark.getLicenseNumber().equals(licenseNumber)) {
//				it.remove();
//				System.out.println("즐겨찾기 삭제되었습니다.");
//			} else {
//				System.out.println("해당 상호명을 즐겨찾기에서 찾을 수 없습니다.");
//			}
//		}
//		
//		
//		System.out.println("<<엔터를 입력하면, 이전 화면으로 이동합니다.>>");
//	// 엔터 입력 대기
//		waitForEnter();
//	
//	// 이전 화면 이동
//		BookmarkHistoryController bookmarkHistoryController = new BookmarkHistoryController();
//		bookmarkHistoryController.bookmarkHistory();
//		
//		
//	}
//
//	private void waitForEnter() {
//		Scanner scan = new Scanner(System.in);
//		scan.nextLine(); // 사용자가 엔터를 입력할 때까지 대기
//	}
//
//	private String findLicenseNumberByStoreName(String inputStoreName) {
//		for (Store store : Data.storeList) {
//			if (store.getStoreName().equals(inputStoreName)) {
//				return store.getLicenseNumber();
//			}
//		}
//
//		return null;
//	}
//}