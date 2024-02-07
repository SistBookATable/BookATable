package com.test.java.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Menu;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.repository.Validation;
import com.test.java.view.SignInView;
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
				loop = false;
				return;
			case 1:
				loop = processSortingOptionByName(searched);
				break;
			case 2:
				// 메뉴명
				loop = processSortingOption(searched);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 0 ~ 2범위의 숫자를 입력하여 주세요.");


			}
		}
	}

	private boolean processSortingOptionByName(ArrayList<Store> searched2) {

		String storeName = storeView.getStoreName();
		searched = searchStoreName(storeName);
		if(searched.isEmpty()) {
			System.out.println();
			System.out.println("음식점 리스트가 없습니다.");
			System.out.println();
			return true;
		}
		
		boolean loop = true;
		
		while (loop) {
			
			storeView.showTitle();
			storeView.show(searched);
			
			storeView.showSelectBox();
			int sortingOption = storeView.get();
			ReservationController reservationController = new ReservationController();

			switch (sortingOption) {
			case 0:
				System.out.println("이전 화면으로 이동합니다.");
				loop = false;
				break;
			case 1:
				// 별점 내림차순으로 정렬
				//Collections.sort(searched, new FindGPAController());
				//storeView.show(searched);
				Collections.sort(searched, (o1, o2)-> (int)(o2.getScore()*10 - o1.getScore()*10));
				break;
			case 2:
				// 리뷰 갯수 내림차순 정렬 등의 다른 정렬 옵션 추가
				// 리뷰 갯수를 읽어오고, 라이센스 번호와 일치하는 목록을 찾은 다음, <Store> searched에서 출력
				Collections.sort(searched, (o1, o2) -> (o2.getReviewCount() - o1.getReviewCount()));
				break;
			case 3:
				//storeView.show(searched);
				Scanner sc = new Scanner(System.in);
				if(!detailPage()) {
					return false;
				}
				break;
			default:
			}
		}
		return true;
	}

	private boolean processSortingOption(ArrayList<Store> searched) {

		String menuName = storeView.getmenuName();   // 메뉴명을 입력하세요, 짜장면 등
		searched = searchMenuName(menuName);
		if(searched.isEmpty()) {
			System.out.println();
			System.out.println("음식점 리스트가 없습니다.");
			System.out.println();
			return true;
		}
		
		boolean loop = true;
		
		while (loop) {
			
			storeView.showTitle();
			storeView.show(searched);
			
			storeView.showSelectBox();
			int sortingOption = storeView.get();
			ReservationController reservationController = new ReservationController();

			switch (sortingOption) {
			case 0:
				System.out.println("이전 화면으로 이동합니다.");
				loop = false;
				break;
			case 1:
				// 별점 내림차순으로 정렬
				//Collections.sort(searched, new FindGPAController());
				//storeView.show(searched);
				Collections.sort(searched, (o1, o2)-> (int)(o2.getScore()*10 - o1.getScore()*10));
				break;
			case 2:
				// 리뷰 갯수 내림차순 정렬 등의 다른 정렬 옵션 추가
				// 리뷰 갯수를 읽어오고, 라이센스 번호와 일치하는 목록을 찾은 다음, <Store> searched에서 출력
				Collections.sort(searched, (o1, o2) -> (o2.getReviewCount() - o1.getReviewCount()));
				break;
			case 3:
				//storeView.show(searched);
				Scanner sc = new Scanner(System.in);
				if(!detailPage()) {
					return false;
				}
				break;
			default:
			}
		}
		return true;
	}
	//				storeView.bookmarkNreservation();
	//				int choice = sc.nextInt();
	//				if(Member.level == 1) {
	//					storeView.reservationNumber();
	//					choice = sc.nextInt();
	//					reservationController.reservation(searched.get(choice-1).getLicenseNumber());
	//				} else {
	//					boolean cycle = true;
	//					while(cycle) {
	//						storeView.noneMemberAvailable();
	//						Scanner scan = new Scanner(System.in);
	//						String input = scan.nextLine();
	//						if((input.equals("Y")) || (input.equals("y"))) {
	//							SignInView.showSelectType();
	//							break;
	//						} else if((input.equals("N")) || (input.equals("n"))) {
	//							storeView.backPage();
	//							break;
	//						} else {
	//							storeView.inputError();
	//							continue;
	//						}
	//					}	
	//				}

	public boolean detailPage() {	// 상세페이지(음식점)
		ReservationController reservationController = new ReservationController();
		SignInController signInController = new SignInController();
		Scanner sc = new Scanner(System.in);
		storeView.bookmarkNreservation();
		int choice = sc.nextInt();

		switch(choice) {
		case 0:
			storeView.backPage();
			return true;
		case 1:	// 예약하기
			if((Member.level == 1) || (Member.level == 2)) {	// 로그인, 일반회원, 업체회원이면
				storeView.show(searched);
				storeView.reservationNumber();	// 예약할 음식점 선택, 번호
				int select = sc.nextInt();
				reservationController.reservation(searched.get(select-1).getLicenseNumber());
			} else if(Member.level == 0) {
				storeView.show(searched);
				storeView.noneMemberAvailable();	// 비회원 회원가입 유무 y/n
				String input = storeView.getTxt();
				if(input.equals("y")) {
					return false;
				} else if(input.equals("n")) {
					storeView.backPage();
					return true;
				} else {
					storeView.inputError();
					return false;
				}
			}
		case 2: // 즐겨찾기 등록
		case 3:	// 즐겨찾기 수정
		case 4:	// 즐겨찾기 삭제
		}
		return true;
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
	}
}