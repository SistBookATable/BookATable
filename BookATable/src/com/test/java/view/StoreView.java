package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Menu;
import com.test.java.model.Store;

/**
 * 음식점 리스트들을 출력하는 StoreView 클래스
 */
public class StoreView {

	public void searchMenu() {
		System.out.println();
		System.out.println("1. 상호명");
		System.out.println("2. 메뉴명");
		System.out.println("0. 이전 화면");
		System.out.println();
	}

	public String getInput(String prompt) {
		Scanner sc = new Scanner(System.in);
		System.out.println(prompt + ": ");
		return sc.nextLine();
	}
	
	public void title() {
		System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("|                                                             음식점 리스트                                                                	  |");
		System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
		}
	
	public void show(Store store, int index) {
		System.out.println("==========================================================================================================================================");
	    String headerFormat = "%-5s%-13s%-31s%-12s%-10s%-40s%-10s%-10s";
	    System.out.printf(headerFormat + "%n", "[No]", "[사업자번호]", "[상호명]", "[전화번호]", "[음식분류]", "[주소]", "[평점]", "[리뷰 갯수]");

	    String dataFormat = "%-5d%-15s%-26s%-16s%-9s%-40s%-10.1f%-15d";
	    System.out.printf(dataFormat + "%n", index, store.getLicenseNumber(), store.getStoreName(), store.getStoreTelNumber(), store.getMenuCategory(), store.getAddress(), store.getScore(), store.getReviewCount());
	    System.out.println("==========================================================================================================================================");
	}
	
	/**
	 * list의 크기만큼 반복하고 음식점 리스트를 출력하고 넘버링 하는 show 메서드
	 */
	public boolean show(ArrayList<Store> storeList) {

		boolean success = true;
		title();
			for (int i=0; i<storeList.size(); i++) {
				show(storeList.get(i), i+1);
			}
			return success;
		}
	
	/**
	 * 사용자로부터 정수값을 입력받아오고 반환하는 get메서드
	 */
	public static int get() {
		return View.getSelectType();
	}
	
	/**
	 * 사용자로부터 문자열을 입력받고 반환하는 getTxt메서드
	 * @return txt
	 */
	public static String getTxt() {
		Scanner sc = new Scanner(System.in);
		String txt = "";
		
		txt = sc.nextLine();
		return txt;
	}

	public String getStoreName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("상호명을 입력해주세요: ");
		String temp = sc.nextLine();
		return temp;
	}

	public String getmenuName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴명을 입력해주세요: ");
		String temp = sc.nextLine();
		return temp;
	}

	public void showSelectBox() {
		System.out.println();
		System.out.println("1. 별점 내림차순 정렬");
		System.out.println("2. 리뷰 갯수 내림차순");
		System.out.println("3. 상세페이지");
		System.out.println("0. 이전 화면");
		System.out.println();
		System.out.print("선택(번호) : ");
	}

	public void bookmarkNreservation() {
		System.out.println();
		System.out.println("1. 예약하기");
		System.out.println("2. 즐겨찾기 등록");
		System.out.println("3. 즐겨찾기 삭제");
		System.out.println("4. 즐겨찾기 조회");
		System.out.println("0. 이전 화면");
		System.out.println();
		System.out.print("선택(번호) : ");
	}

	public void reservationNumber() {
		System.out.println();
		System.out.print("예약할 음식점 선택(번호): ");
		System.out.println();
	}

	public void noneMemberAvailable() {
		System.out.println();
		System.out.println("┌─────────────────────────────────────────────────────────────────┐");
		System.out.println("|   비회원은 회원 가입 후 이용가능합니다. 회원가입 페이지로 이동하시겠습니까?(y/n) 	  |");
		System.out.println("└─────────────────────────────────────────────────────────────────┘");
		System.out.println();
		System.out.print("■ 입력 :\t■");
	}
	
	public void noneBusinessUserAvailable() {
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────────┐");
		System.out.println("|                    업체회원은 예약이 불가능합니다.                	|");
		System.out.println("└───────────────────────────────────────────────────────────┘");
		System.out.println();
	}

	public void backPage() {
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		System.out.println("\t\t\t이전 페이지로 이동합니다\t\t\t");
		System.out.println("---------------------------------------------------------------------");
		System.out.println();
	}
	
	public void inputError() {
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("\t\t\t잘못 입력하셨습니다. 다시 입력해주세요.\t\t");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println();
		
	}
	
	/**
	 * 즐겨찾는 음식점 목록을 보여주는 showBookmarkedStores 메서드
	 * list의 크기만큼 돌아 store 객체에 저장하고 1. 음식점명으로 출력 후
	 * 음식점 리스트를 출력하는 show 메서드 호출
	 * @param bookmarkedStores 즐겨찾는 음식점 목록이 담긴 ArrayList
	 */
	public void showBookmarkedStores(ArrayList<Store> bookmarkedStores) {
	    if (bookmarkedStores.isEmpty()) {
	        System.out.println("현재 즐겨찾기된 음식점이 없습니다.");
	    } else {
	        System.out.println("즐겨찾는 음식점 목록:");
	        for (int i = 0; i < bookmarkedStores.size(); i++) {
	            Store store = bookmarkedStores.get(i);
	            System.out.println((i+1) + ". " + store.getStoreName());
	            show(store, i+1);
	        }
	    }
	}
}