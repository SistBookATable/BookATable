package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Bookmark;
import com.test.java.model.Store;
import com.test.java.repository.Data;

/**
 * 상세페이지 이동 화면을 출력하는 View 클래스입니다.
 */
public class MoveStorePageView {

	/**
	 * 사용자로부터 상호명을 입력받는 메서드입니다.
	 * @return 사용자가 입력한 상호명
	 */
	public static String getStoreName() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";

		while (true) {
			System.out.print("상세페이지 보기를 원하는 상호명을 입력해주세요: ");
			tmp = scan.nextLine();

			break;
		}
		return tmp;
	}

	// Store store

	/**
	 * 상세페이지를 출력하는 메서드입니다.
	 * @param name 음식점 이름 
	 * @param telNumber 전화번호
	 * @param address 주소
	 * @param menuCategory 음식 분류
	 * @param menu 메뉴
	 * @param table 테이블 수 
	 * @param score 평점
	 */
	public void showStorePage(String name, String telNumber, String address, String menuCategory, String menu,
			int table, double score) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("	 %20s		 		\n", name);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out
				.println("==========================================================================================");
		System.out.println();
		System.out.printf("■           전화번호 : 		    %-20s\n", telNumber);
		System.out.printf("■           주소 :	 %-20s\n", address);
		System.out.printf("■           음식분류 : 			%-20s\n", menuCategory);
		System.out.printf("■           메뉴 :	 		%-20s\n", menu);
		System.out.printf("■           테이블 :			%d\n", table);
		System.out.printf("■           평점 :	 		%.1f\n", score);
		System.out.println();
		System.out
				.println("==========================================================================================");
		System.out.println();

		View.pause();

	}

}