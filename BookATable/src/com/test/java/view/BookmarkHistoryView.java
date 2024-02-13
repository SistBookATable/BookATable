package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Bookmark;
import com.test.java.model.Member;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.Data;

/**
 * 즐겨찾기 조회 화면을 출력하고 관련 메뉴를 제공하는 View 클래스입니다.
 */
public class BookmarkHistoryView {

	/**
	 * 즐겨찾기 조회 화면의 제목을 출력하는 메서드입니다. 
	 * @param name 사용자 이름
	 */
	public static void showTitle(String name) {

		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 즐겨찾기		   ■", name);
		System.out.println();
		System.out
				.println("------------------------------------------------------------------------------------------");

		String header = String.format("%-10s%20s%20s", "[상호명]", "[전화번호]", "[메뉴]");
		System.out.println(header);

	}

	/**
	 * 즐겨찾기 리스트를 출력하여 보여주는 메서드입니다.
	 * @param storeName 상호명
	 * @param storeTel 전화번호
	 * @param menu 메뉴
	 */
	public static void showBookmarkHistory(String storeName, String storeTel, String menu) {

		String body = String.format("%-10s\t\t%-12s\t\t%6s", storeName, storeTel, menu);
		System.out.println(body);

	}

	/**
	 * 사용자에게 선택지를 출력하는 메서드입니다.
	 */
	public static void showSelectBox() {
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■           1. 상세페이지 이동	   \t■");
		System.out.println("■           2. 즐겨찾기 삭제	   \t■");
		System.out.println("■           0. 이전 화면		   \t■");
		System.out.println();
		System.out
				.println("------------------------------------------------------------------------------------------");

		System.out.println();

		System.out.print("선택(번호) : ");
	}

	/**
	 * 사용자의 선택을 입력 받고 반환하는 메서드입니다. 
	 * @return 사용자의 선택지를 나타내는 정수값
	 */
	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		return temp;
	}

}
