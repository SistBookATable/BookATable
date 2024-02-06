package com.test.java.controller;

import com.test.java.model.Bookmark;
import com.test.java.model.Member;
import com.test.java.model.Menu;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.BookmarkHistoryView;

public class BookmarkHistoryController {
	
	public void bookmarkHistory() {
		
//		// 사용자의 즐겨찾기 목록에서 음식점의 사업자등록번호 가져오기
//		String userId = Member.id; //사용자의 아이디
//		String licenseNumber = findBookmarkById(userId);
		
//		// 음식점의 사업자등록번호로 음식점 정보 가져오기
//		String storeName = findStoreNameBylicenseNumber(licenseNumber);
//		String storeTelNumber = findStoreTelNumberBylicenseNumber(licenseNumber);
//		String menuName = findMenuNameBylicenseNumber(licenseNumber);
		
		BookmarkHistoryView.showBookmarkHistory(findNameById(Member.id)
												, findStoreNameById(Member.id)
												, findStoreTelNumberById(Member.id)
												, findMenuNameById(Member.id));
		
		
		BookmarkHistoryView.showSelectBox();
		int choice = BookmarkHistoryView.get();
		
		boolean loop = true;
		while(loop) {
			switch(choice) {
			// 상세페이지 보기
			case 1:
				MoveStorePageController moveStorePageController = new MoveStorePageController();
				moveStorePageController.moveStorePage();
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
	
	private String findMenuNameById(String id) {
		for(Bookmark b : Data.bookmarkList) {
			if (b.getUserId().equals(id)) {
				for(Menu m : Data.menuList) {
					if (m.getLicenseNumber().equals(b.getLicenseNumber())) {
						return m.getMenuName();
					}
				}
			}
		}
		return null;
	}



	private String findStoreTelNumberById(String id) {
		for(Bookmark b : Data.bookmarkList) {
			if (b.getUserId().equals(id)) {
				for(Store s : Data.storeList) {
					if (s.getLicenseNumber().equals(b.getLicenseNumber())) {
						return s.getStoreTelNumber();
					}
				}
			}
		}
		return null;
	}

	private String findStoreNameById(String id) {
		for(Bookmark b : Data.bookmarkList) {
			if (b.getUserId().equals(id)) {
				for(Store s : Data.storeList) {
					if (s.getLicenseNumber().equals(b.getLicenseNumber())) {
						return s.getStoreName();
					}
				}
			}
		}
		return null;
	}

	private String findNameById(String id) {
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				return u.getName();	
				}
			}
		return null;
		}	

}
