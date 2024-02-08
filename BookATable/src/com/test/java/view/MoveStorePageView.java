package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Bookmark;
import com.test.java.model.Store;
import com.test.java.repository.Data;

public class MoveStorePageView {

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