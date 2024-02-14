package com.test.java.controller;

import java.util.ArrayList;
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

/**
 * 즐겨찾기 조회와 관리를 담당하는 Controller 클래스입니다.
 */
public class BookmarkHistoryController {

	/**
	 * 사용자의 즐겨찾기 리스트를 조회하고 상세페이지 이동, 삭제할 수 있는 메서드입니다. 
	 */
	public void bookmarkHistory() {

		boolean loop = true;
		while (loop) {
			// 본인 즐겨찾기 조회 리스트
			ArrayList<Bookmark> bookmarkList = findAllBook(Member.id);

			String name = MemberRepository.findOneById(Member.id).getName();
			BookmarkHistoryView.showTitle(name);

			for (Bookmark b : bookmarkList) {
				String storeName = findStoreNameByLisence(b.getLicenseNumber());
				String storeTel = findStoreTelByLisence(b.getLicenseNumber());
				String menu = findMenuByLisence(b.getLicenseNumber());
				BookmarkHistoryView.showBookmarkHistory(storeName, storeTel, menu);
			}

			BookmarkHistoryView.showSelectBox();
			int choice = BookmarkHistoryView.get();

			switch (choice) {
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

	/**
	 * 사용자 ID로 즐겨찾기 목록을 조회하는 메서드입니다. 
	 * @param id 사용자 ID
	 * @return 사용자ID에 해당하는 즐겨찾기 목록을 반환합니다. 
	 */
	private ArrayList<Bookmark> findAllBook(String id) {

		ArrayList<Bookmark> tmp = new ArrayList<>();
		for (Bookmark m : Data.bookmarkList) {
			if (m.getUserId().equals(id)) {
				tmp.add(m);
			}
		}
		return tmp;
	}

	/**
	 * 사업자등록번호로 메뉴를 조회하는 메서드입니다. 
	 * @param licenseNumber 사업자등록번호
	 * @return 사업자등록번호에 해당하는 메뉴를 반환합니다. 없는 경우, null을 반환합니다.
	 */
	private String findMenuByLisence(String licenseNumber) {
		for (Menu m : Data.menuList) {
			if (m.getLicenseNumber().equals(licenseNumber)) {
				return m.getMenuName();
			}
		}
		return null;
	}

	/**
	 * 사업자등록번호로 전화번호를 조회하는 메서드입니다. 
	 * @param licenseNumber 사업자등록번호
	 * @return 사업자등록번호에 해당하는 전화번호를 반환합니다. 없는 경우, null을 반환합니다.
	 */
	private String findStoreTelByLisence(String licenseNumber) {
		for (Store s : Data.storeList) {
			if (s.getLicenseNumber().equals(licenseNumber)) {
				return s.getStoreTelNumber();
			}
		}
		return null;
	}

	/**
	 * 사업자등록번호로 상호명을 조회하는 메서드입니다. 
	 * @param licenseNumber 사업자등록번호
	 * @return 사업자등록번호에 해당하는 상호명을 반환합니다. 없는 경우, null을 반환합니다.
	 */
	private String findStoreNameByLisence(String licenseNumber) {
		for (Store s : Data.storeList) {
			if (s.getLicenseNumber().equals(licenseNumber)) {
				return s.getStoreName();
			}
		}
		return null;
	}

}
