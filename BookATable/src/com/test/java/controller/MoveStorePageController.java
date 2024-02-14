package com.test.java.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.test.java.model.Menu;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.model.Table;
import com.test.java.repository.Data;
import com.test.java.repository.StoreRepository;
import com.test.java.view.MoveStorePageView;

/**
 * 상세페이지 이동을 처리하는 Controller 클래스입니다.
 */
public class MoveStorePageController {

	/**
	 * 상세페이지로 이동하는 메서드입니다.
	 * 사용자로부터 상호명을 입력받아 해당 음식점의 상세정보를 출력합니다. 
	 */
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
			moveStorePageView.showStorePage(storeName, telPhone, address, menuCategory, menu, table, score); // store
		} else {
			System.out.println("해당 음식점이 존재하지 않습니다.");
		}

	}

	/**
	 * 사업자번호를 기반으로 메뉴 정보를 조회하는 메서드입니다. 
	 * @param licenseNumber 사업자번호
	 * @return 사업자번호에 해당하는 메뉴를 반환합니다. 없는 경우, null을 반환합니다.
	 */
	private String findMenu(String licenseNumber) {
		for (Menu menu : Data.menuList) {
			if (menu.getLicenseNumber().equals(licenseNumber)) {
				return menu.getMenuName();
			}
		}
		return null;
	}

	/**
	 * 사업자번호를 기반으로 테이블 정보를 조회하는 메서드입니다. 
	 * @param licenseNumber 사업자번호 
	 * @return 사업자번호에 해당하는 테이블을 반환합니다. 없는 경우, 0을 반환합니다. 
	 */
	private int findTable(String licenseNumber) {
		for (Table table : Data.tableList) {
			if (table.getLicenseNumber().equals(licenseNumber)) {
				return table.getTableCapacity();
			}
		}
		return 0;
	}

}