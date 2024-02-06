package com.test.java.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.test.java.model.Menu;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.Data;
//import com.test.java.view.MenuView;
import com.test.java.view.StoreView;

public class StoreController {

	private StoreView storeView;
	private Store store;

	public StoreController() {
		this.storeView = new StoreView();
	}
	

	ArrayList<Store> searched = new ArrayList<>();
	ArrayList<Menu> searchMenu = new ArrayList<>();
	ArrayList<Review> reviewCount = new ArrayList<>();

	public void run() {
	StoreView storeView = new StoreView();


		boolean loop = true;
		while(loop) {

			storeView.searchMenu();
			int choice = storeView.get();

			switch(choice) {
			case 0:
				System.out.println("이전 화면으로 이동합니다.");
				return;
			case 1:
				String storeName = StoreView.getStoreName();
				searched = searchStoreName(storeName);
				storeView.show(searched);
				processSortingOption(searched);
				break;
			case 2:
				String menuName = storeView.getmenuName();   // 메뉴명을 입력하세요, 짜장면 등
				searched = searchMenuName(menuName);
				storeView.show(searched);	//
				processSortingOption(searched);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	private void processSortingOption(ArrayList<Store> searched) {

		while (true) {
			storeView.showSelectBox();
			int sortingOption = storeView.get();
			ReservationController reservationController = new ReservationController();
			
			switch (sortingOption) {
			case 0:
				System.out.println("이전 화면으로 이동합니다.");
				return;
			case 1:
				// 별점 내림차순으로 정렬
				Collections.sort(searched, new FindGPAController());
				storeView.show(searched);
				break;
			case 2:
				// 역으로부터 거리 오름차순 정렬 등의 다른 정렬 옵션 추가
				Collections.sort(searched, new FindDistanceFromController());
				storeView.show(searched);
				break;
			case 3:
				Data.reviewCount();
				// 리뷰 갯수 내림차순 정렬 등의 다른 정렬 옵션 추가
				// 리뷰 갯수를 읽어오고, 라이센스 번호와 일치하는 목록을 찾은 다음, <Store> searched에서 출력
				Collections.sort(searched, new FindReviewCountController());
				storeView.show(searched);
				break;
			case 4:
				storeView.show(searched);
				Scanner sc = new Scanner(System.in);
				storeView.bookmarkNreservation();
				int choice = sc.nextInt();
				storeView.reservationNumber();
				choice = sc.nextInt();
				reservationController.reservation(searched.get(choice-1).getLicenseNumber());
//				System.out.println(searched.get(choice-1).getLicenseNumber());
				break;
				
//				for(int i=0; i<searched.size(); i++) {
//					System.out.println();
//					if(choice == i) {
//						System.out.println(searched.get(i));
//						String licenseNumber = store.getLicenseNumber();
//					} else {
//						break;
//					}
//				}
			default:
				System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
			}
		}
	}

	private ArrayList<Store> searchReviewCount(String menu) {
		ArrayList<Store> tmp = new ArrayList<>();

		for(Review r : Data.reviewList) {
			if(r.getLicenseNumber().equals(menu)) {
				String licenseNumber = r.getLicenseNumber();

				for(Store s : Data.storeList) {
					if(s.getLicenseNumber().equals(licenseNumber)) {
						tmp.add(s);
					}
				}
			}
		}
		return tmp;
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
					}
				}

			}
		}
		return tmp;

	}

	private ArrayList<Store> searchStoreName(String keyword) {
		ArrayList<Store> tmp = new ArrayList<>();
		String same = keyword;
		for(Store store : Data.storeList) {
			if(store.getStoreName().contains(same)) {
				tmp.add(store);
			}
		}
		return tmp;
		// 별점순, 거리순, 리뷰순 정렬
	}
}