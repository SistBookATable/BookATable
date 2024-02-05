package com.test.java.controller;

import java.util.Scanner;

import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.MoveStorePageView;

public class MoveStorePageController {
	
	public void moveStorePage() {
		
		MoveStorePageView moveStorePageView = new MoveStorePageView();
		
		String storeName = moveStorePageView.getStoreName();
		
		Store store = findStoreByName(storeName);
		
		if (store != null) {
			moveStorePageView.showStorePage(store);
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
