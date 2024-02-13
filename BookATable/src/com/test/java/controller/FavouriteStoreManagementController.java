package com.test.java.controller;

import java.util.Scanner;

import com.test.java.view.FavoriteStoreManagementView;

/**
 * 사용자가 즐겨찾는 매장을 관리하는 메뉴를 처리하는 Controller 클래스입니다. 
 * 사용자가 메뉴를 선택할 때마다 해당하는 기능을 실행합니다.
 */
public class FavouriteStoreManagementController {

	public void favouriteStoreManagement() {
		

		
		FavoriteStoreManagementView favouriteStoreManagementView = new FavoriteStoreManagementView();
		
		boolean loop = true;
		
		while (loop) {
			favouriteStoreManagementView.showFavoriteStoreManagement();
			int choice = favouriteStoreManagementView.get();
			
			switch (choice) {
			// 작성 리뷰 조회		
			case 1: 
				WrittenReviewHistoryController writtenReviewHistoryController = new WrittenReviewHistoryController();
				writtenReviewHistoryController.writtenReviewHistory();
				break;
			// 즐겨찾기 조회
			case 2:
				BookmarkHistoryController bookmarkHistoryController = new BookmarkHistoryController();
				bookmarkHistoryController.bookmarkHistory();
				break;
			// 즐겨찾기 삭제
//			case 3:
//				DeleteBookmarkController deleteBookmarkController = new DeleteBookmarkController();
//				deleteBookmarkController.deleteBookmark();
//				break;
			// 이전화면
			case 0: 
				loop = false;
				break;
			
			}
		}
		
	}
	
	
}
