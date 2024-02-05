package com.test.java.controller;

import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.DeleteBookmarkView;

public class DeleteBookmarkController {
	
	public void deleteBookmark() {
		
		
		DeleteBookmarkView deleteBookmarkView = new DeleteBookmarkView();
		String storeName = deleteBookmarkView.getStoreName();
		
		Store store = findStoreByName(storeName);
		// 현재 로그인한 사용자 아이디 
		String userId = Member.id;

		
		if (store != null) {
			// 즐겨찾기에서 해당 음식점을 현재 로그인한 사용자의 아이디로 매칭되는 것만 삭제
			for (int i = 0; i < Data.bookmarkList.size(); i++) {
				if (Data.bookmarkList.get(i).getLicenseNumber().equals(store.getLicenseNumber()) 
						&& Data.bookmarkList.get(i).getUserId().equals(userId)) {
					Data.bookmarkList.remove(i);
					deleteBookmarkView.message();
					break; // 한번만 삭제
				}
			}
		
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
	
	
	private void waitForEnter() {
		Scanner scan = new Scanner(System.in);
		scan.nextLine(); // 사용자가 엔터를 입력할 때까지 대기
		
	}

	private Store findStoreByName(String storeName) {
		for (Store store : Data.storeList) {
			if (store.getStoreName().equals(storeName)) {
				return store;
			}
		}
		return null;
	}
	
	
	
	

}
