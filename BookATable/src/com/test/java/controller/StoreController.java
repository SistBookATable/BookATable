package com.test.java.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.test.java.model.Menu;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.StoreView;

public class StoreController {

	public void run() {
		
		StoreView storeView = new StoreView();
		
		boolean loop = true;
		while(loop) {

			storeView.searchMenu();
			int choice = storeView.get();
			
			switch(choice) {
			case 0:
				System.out.println("이전 화면으로 이동합니다.");
				break;
			case 1:
				
				// FindByNameController findByNameController = new FindByNameController();
				String storeName = StoreView.getStoreName();
				ArrayList<Store> searched = searchStoreName(storeName);
				storeView.show(searched);
				storeView.showSelectBox();
				storeView.get();
				storeView.showSelectBox();
				
				break;
				
			case 2:
				String menuName = storeView.getmenuName();
				ArrayList<Store> searchByMenu = searchMenuName(menuName);
				storeView.show(searchByMenu);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

			}
			
		}
		
		

		while(true) {
			storeView.searchMenu();

			int choice = StoreView.get();

			switch(choice) {
			case 0:
				System.out.println("이전 화면으로 이동합니다.");
				break;
			case 1:
				try {
					String storeName = StoreView.getStoreName();
					searchStoreName(storeName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					String menuName = storeView.getmenuName();
					searchMenuName(menuName);
				} catch (Exception e) {
					System.out.println("StoreController.run");
					e.printStackTrace();
				}
				
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

			}
		}
	}
	private ArrayList<Store> searchStoreName(String keyword) {

		ArrayList<Store> tmp = new ArrayList<>();
		
		for(Store store : Data.storeList) {
			if(store.getStoreName().equals(keyword)) {
				tmp.add(store);
			}
		}
		
		return tmp;
		// 별점순, 거리순, 리뷰순 정렬

	}

	private ArrayList<Store> searchMenuName(String menu) {
		
		ArrayList<Store> tmp = new ArrayList<>();
		
		for(Menu m : Data.menuList) {
			
			//메뉴 이름이 검색한 값과 같은지 확인
			if(m.getMenuName().equals(menu)) {
				
				String licenseNumber = m.getLicenseNumber();
				
				//라이센스 넘버가 같은 스토어 찾기
				for(Store store : Data.storeList) {
					
					//라이센스 넘버가 같으면 tmp에 넣기
					if(store.getLicenseNumber().equals(licenseNumber)) {
						tmp.add(store);
						break;
					}
				}
				
			}
		}
		return tmp;
		
	}
}

