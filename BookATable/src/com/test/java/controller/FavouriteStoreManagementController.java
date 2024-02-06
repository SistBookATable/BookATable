package com.test.java.controller;

import java.util.Scanner;

import com.test.java.view.FavoriteStoreManagementView;

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
			// 즐겨찾기 조회 BookmarkHistory
			case 2:
				BookmarkHistoryController bookmarkHistoryController = new BookmarkHistoryController();
				bookmarkHistoryController.bookmarkHistory();
				break;
			// 즐겨찾기 삭제
			case 3:
				DeleteBookmarkController deleteBookmarkController = new DeleteBookmarkController();
				deleteBookmarkController.deleteBookmark();
				break;
			// 이전화면
			case 0: 
				loop = false;
				break;
			
			}
		}
		
	}
	
	
}
